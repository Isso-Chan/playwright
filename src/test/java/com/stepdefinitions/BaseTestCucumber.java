package com.stepdefinitions;



import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.pages.HomePageCucumber;
import com.pages.LoginPageCucumber;
import com.qa.opencart.factory.PlaywrightFactory;

import java.util.Properties;

public class BaseTestCucumber {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext browserContext;
    protected Properties prop;

    protected Page page;

     HomePageCucumber homePageCucumber;
     LoginPageCucumber loginPageCucumber;


    public BaseTestCucumber() {
        this.playwright= PlaywrightFactory.getPlaywright();
        this.browser=PlaywrightFactory.getBrowser();
        this.browserContext=PlaywrightFactory.getBrowserContext();
        this.prop=PlaywrightFactory.init_prop();
        this.page = PlaywrightFactory.getPage();

        homePageCucumber = new HomePageCucumber(page);
        loginPageCucumber = new LoginPageCucumber(page);
    }
}
