package com.stepdefinitions;

import com.factory.PlaywrightFactory;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.pages.HomePage;
import com.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.runners.Parameterized;

import java.util.Properties;

public class BaseTest {
//
//    PlaywrightFactory pf;
//    Page page;
//    protected Properties prop;
//
//    protected HomePage homePage;
//    protected LoginPage loginPage;
//
//
//    @Before
//    public void setup() {
//        pf = new PlaywrightFactory();
//
//        prop = pf.init_prop();
//
////        if (browserName != null) {//if browser is defined inside xml file, then use it, otherwise use the one defined in config.properties file
//            prop.setProperty("browser", prop.getProperty("browser"));
////        }
//
//        page = pf.initBrowser(prop);
//        homePage = new HomePage(page);
//    }
//
//    @After
//    public void tearDown() {
//        page.context().browser().close();
//    }

}
