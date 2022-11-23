package com.testrunner;

import com.qa.opencart.listeners.ExtentReportListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@CucumberOptions(tags = "@all",
        features = {"src/test/resources/features/"},
        glue = {"com/stepdefinitions"},
        plugin = {
                "json:target/cucumber.json",
                "html:target/cucumbertests-html-reports",
                "rerun:target/rerun.txt",
                "pretty"
})
@Listeners({ExtentReportListener.class})
public class CucumberTestsRunner extends AbstractTestNGCucumberTests {

}
