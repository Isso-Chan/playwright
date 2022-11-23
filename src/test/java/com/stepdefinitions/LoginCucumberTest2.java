package com.stepdefinitions;

import com.qa.opencart.base.BaseTest;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginCucumberTest2 extends BaseTestCucumber {

    @Then("User verify the product name {string}")
    public void user_verify_the_product_name(String productname) {
        String productName = homePageCucumber.getProductName();
        Assert.assertEquals(productName, productname);
    }
    @Then("User logout from the application")
    public void user_logout_from_the_application() {
        loginPageCucumber.logoutApplication();
    }

}
