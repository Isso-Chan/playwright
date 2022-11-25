package com.stepdefinitions;

import com.factory.PlaywrightFactory;
import com.microsoft.playwright.Page;
import com.pages.HomePage;
import com.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class LoginCucumberTest2 extends BaseTest{

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
