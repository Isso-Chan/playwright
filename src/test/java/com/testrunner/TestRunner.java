package com.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@all",
        features = {"src/test/resources/features/"},
        glue = {"com/stepdefinitions"},
        plugin =  {})
public class TestRunner extends AbstractTestNGCucumberTests{

}
