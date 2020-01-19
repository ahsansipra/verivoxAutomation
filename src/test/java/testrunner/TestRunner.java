package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:Feature.feature", glue = { "stepdefinition" }, plugin = { "pretty",
		"html:target/cucumber-reports" }, monochrome = true
// dryRun= true
)
public class TestRunner {

}
