package com.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginCucumberTest extends BaseTestCucumber {


    @Given("User launched SwagLabs application")
    public void user_launched_swag_labs_application() {
//        page.navigate(prop.getProperty("url2").trim());

    }
    @When("User verify the Page title")
    public void user_verify_the_page_title() {
        String title = loginPageCucumber.verifyTitle();
        Assert.assertEquals(title, "Swag Labs");
    }
    @When("User logged in the app using username {string} and password {string}")
    public void user_logged_in_the_app_using_username_and_password(String username, String password) {
        loginPageCucumber.loginIntoApplication(username, password);
    }
}
