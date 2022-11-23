package com.stepdefinitions;

import com.utilities.PlaywrightFactory;
import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.*;
public class Hooks {

    PlaywrightFactory pf;
    Page page;
    protected Properties prop;

    @Before
    public void setup(Scenario scenario) {
        pf = new PlaywrightFactory();

        prop = pf.init_prop();

//        if (browserName != null) {//if browser is defined inside xml file, then use it, otherwise use the one
//        defined in config.properties file
        prop.setProperty("browser", prop.getProperty("browser"));
//        }

        page = pf.initBrowser(prop);
        LoggerFactory.getLogger(Hooks.class).warn("*** New starting scenario :" + scenario.getName());
        setAllureEnvironment();
    }

    public void setAllureEnvironment() {
        //this method provides info for Environment part of Allure-Report
        try (OutputStream output = new FileOutputStream("target/allure-results/environment.properties")) {

            Properties properties = new Properties();
            String enroll_url = prop.getProperty("url");
            String browser = prop.getProperty("browser");

            // set the properties value
            properties.setProperty("Enroll", enroll_url);
            properties.setProperty("Browser", browser);
            properties.setProperty("Project_Name", "XYZ-123");

            // save properties to project root folder
            properties.store(output, null);
//            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    //
    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot;
           Map<String, Object> map = PlaywrightFactory.getThreadMap();
            System.out.println(" Map to be deleted = " + map);
//            System.out.println("Array to be deleted = " + array);
                for (String key : map.keySet()) {
                    if (key.startsWith("screenShot")) {
                        screenshot = (byte[]) map.get(key);
                        scenario.attach(
                                screenshot,
                                "image/png",
                                scenario.getName() + "_" + key);
                    }
                }
        }
        // remove all objects created by in Thread
        PlaywrightFactory.removeThreadMap();
        PlaywrightFactory.removeSoftAssert();
        page.context().browser().close();
    }
}
