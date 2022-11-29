package com.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    plugin = {"html:target/failed-html-report"},
    features = "@target/rerun.txt",
    glue = "com/stepdefinitions")
public class FailedCukesTestsRunner extends AbstractTestNGCucumberTests {}


