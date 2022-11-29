package com.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"com/stepdefinitions"},
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt",},
        dryRun = false,
        tags = "@all",
        monochrome = false
)
public class TestRunner {

}
