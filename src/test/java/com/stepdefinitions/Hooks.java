package com.stepdefinitions;

import com.utilities.PlaywrightFactory;
import com.microsoft.playwright.Page;
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

        prop = pf.init_prop();

//        if (browserName != null) {//if browser is defined inside xml file, then use it, otherwise use the one defined in config.properties file
            prop.setProperty("browser", prop.getProperty("browser"));
//        }

        page = pf.initBrowser(prop);
    }
//
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = page.screenshot();
//                    ((TakesScreenshot) MyDriver.get()).getScreenshotAs(OutputType.BYTES); This line is for Selenium
            scenario.attach(
                    screenshot,
                    "image/png",
                    "screenshot_" + scenario.getName() + "_" + new Date().getTime());
        }
        page.context().browser().close();
    }

}
