package com.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"com/stepdefinitions"},
        plugin = {"pretty",
        "json:target/MyReports/report.json",
        "junit:target/MyReports/report-xml"},
        dryRun = false,
        tags = "@all",
        monochrome = false
//        publish = true-> Instead of this line, cucumber.properties file was generated and "cucumber.publish.enabled=true" added
)
public class TestRunner {

}
