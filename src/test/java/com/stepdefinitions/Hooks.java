package com.stepdefinitions;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.factory.PlaywrightFactory;
import com.microsoft.playwright.Page;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.annotations.Listeners;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

@Listeners({ExtentITestListenerClassAdapter.class})
public class Hooks {

    PlaywrightFactory pf;
    Page page;
    protected Properties prop;
    @Before
    public void setup() {
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        prop.setProperty("browser", prop.getProperty("browser"));
        page = pf.initBrowser(prop);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            //This part is for HTML reports
            final byte[] screenshot = page.screenshot();
            scenario.attach(
                    screenshot,
                    "image/png",
                    "screenshot_" + scenario.getName() + "_" + Calendar.getInstance().getTime());

            //This line is for ExtendTestManager to set screenshot into the report
            ExtentTestManager.getTest().addScreenCaptureFromBase64String(PlaywrightFactory.takeScreenshot());
        }
        page.context().browser().close();
    }

}
