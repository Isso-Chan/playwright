package com.qa.opencart.base;

import java.util.Properties;

import com.pages.HomePageCucumber;
import com.pages.LoginPageCucumber;
import com.qa.opencart.factory.PlaywrightFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;

import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {

	PlaywrightFactory pf;
	Page page;
	protected Properties prop;

	protected HomePage homePage;
	protected LoginPage loginPage;
	protected LoginPageCucumber loginPageCucumber;
	protected HomePageCucumber homePageCucumber;


	@Parameters({ "browser" })//This will get the values of browsers written in regression.xml file and pass it to browserName in setUp()
	@BeforeTest
	public void setup(String browserName) {
//		browserName="chromium";
		pf = new PlaywrightFactory();

		prop = pf.init_prop();

		if (browserName != null) {//if browser is defined inside xml file, then use it, otherwise use the one defined in config.properties file
			prop.setProperty("browser", browserName);
		}

		page = pf.initBrowser(prop);
		homePage = new HomePage(page);
		loginPage=new LoginPage(page);

		page.navigate(prop.getProperty("url").trim());
	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}