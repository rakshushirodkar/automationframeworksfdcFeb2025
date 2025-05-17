package runnerfiles;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/features/", glue = { "stepdefinitions"}, 
tags = "@regression", plugin = {"pretty","html:target/cucumber-reports.html"}, monochrome = true, dryRun = true )

public class TestRunner {

}
