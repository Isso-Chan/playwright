package com.stepdefinitions;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.Date;
import java.util.Properties;

public class Hooks {
    PlaywrightFactory pf;
    Page page;
    protected Properties prop;


    @Before
    public void setup() {
        pf = new PlaywrightFactory();
        prop = PlaywrightFactory.init_prop();
        prop.setProperty("browser", prop.getProperty("browser"));
        page = pf.initBrowser(prop);
    }
    @After
    public void tearDown(Scenario scenario) {
//        if (scenario.isFailed()) {
//            final byte[] screenshot = PlaywrightFactory.takeScreenshot().getBytes();
//            scenario.attach(
//                    screenshot,
//                    "image/png",
//                    "screenshot_" + scenario.getName() + "_" + new Date().getTime());
//        }
        page.close();
    }
}
