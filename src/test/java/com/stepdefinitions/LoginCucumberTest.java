package com.stepdefinitions;

import com.factory.PlaywrightFactory;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.pages.HomePage;
import com.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Properties;


public class LoginCucumberTest {

    PlaywrightFactory pf=new PlaywrightFactory();
    protected Properties prop=pf.init_prop();;
    Page page=pf.initBrowser(prop);
    protected HomePage homePage;
    protected LoginPage loginPage;




    @Given("User launched SwagLabs application")
    public void user_launched_swag_labs_application() {
//        page.navigate("https://www.saucedemo.com/");
        homePage = new HomePage(page);
        loginPage = new LoginPage(page);
    }
    @When("User verify the Page title")
    public void user_verify_the_page_title() {
        String title = loginPage.verifyTitle();
        Assert.assertEquals(title, "Swag Labs");
    }
    @When("User logged in the app using username {string} and password {string}")
    public void user_logged_in_the_app_using_username_and_password(String username, String password) {
        loginPage.loginIntoApplication(username, password);
    }
    @Then("User verify the product name {string}")
    public void user_verify_the_product_name(String productname) {
        String productName = homePage.getProductName();
        Assert.assertEquals(productName, productname);
    }
    @Then("User logout from the application")
    public void user_logout_from_the_application() {
        loginPage.logoutApplication();
    }


}
