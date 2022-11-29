package com.stepdefinitions;

import com.factory.PlaywrightFactory;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.pages.HomePage;
import com.pages.LoginPage;

import java.util.Properties;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext browserContext;
    protected Properties prop;
    protected Page page;

    protected HomePage homePage;
    protected LoginPage loginPage;


    public BaseTest() {
        this.playwright=PlaywrightFactory.getPlaywright();
        this.browser=PlaywrightFactory.getBrowser();
        this.browserContext=PlaywrightFactory.getBrowserContext();
        this.prop=PlaywrightFactory.init_prop();
        this.page = PlaywrightFactory.getPage();

        homePage = new HomePage(page);
        loginPage = new LoginPage(page);
    }

}
