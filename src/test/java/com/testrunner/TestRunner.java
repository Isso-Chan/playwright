package com.testrunner;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@CucumberOptions(tags = "@all",
        features = {"src/test/resources/features/"},
        glue = {"com/stepdefinitions"},
        plugin =  {"json:target/cucumber.json",
                "html:target/default-html-reports",})
@Listeners({ExtentITestListenerClassAdapter.class})
public class TestRunner extends AbstractTestNGCucumberTests{

}
