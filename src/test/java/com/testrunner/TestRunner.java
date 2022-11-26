package com.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"com/stepdefinitions"},
        plugin = {"pretty",
                "json:target/ReportsFromCukesRunner/report.json",
                "junit:target/ReportsFromCukesRunner/report-xml",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt",},
        dryRun = false,
        tags = "@all",
        monochrome = false
//        publish = true-> Instead of this line, cucumber.properties file was generated and "cucumber.publish
//        .enabled=true" added
)
public class TestRunner {

}
