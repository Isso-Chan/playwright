package com.stepdefinitions;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.listeners.ExtentReportListener;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.ITestResult;
import org.testng.internal.TestResult;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class Hooks {
    PlaywrightFactory pf;
    Page page;
    protected Properties prop;

    @Before
    public void setAllureEnvironment() {
        //this method provides info for Environment part of Allure-Report
        try (OutputStream output = new FileOutputStream("target/allure-results/environment.properties")) {

            Properties prop = new Properties();
            String url = PlaywrightFactory.init_prop().getProperty("url");
            String browser = PlaywrightFactory.init_prop().getProperty("browser");

            // set the properties value
            prop.setProperty("Url", url);
            prop.setProperty("Browser", browser);
            prop.setProperty("Project_Name", "Playwright Demo");

            // save properties to project root folder
            prop.store(output, null);

//            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }
    @Before
    public void setup() {
        pf = new PlaywrightFactory();
        prop = PlaywrightFactory.init_prop();
        prop.setProperty("browser", prop.getProperty("browser"));
        page = pf.initBrowser(prop);
    }
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = PlaywrightFactory.getPage().screenshot();
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
