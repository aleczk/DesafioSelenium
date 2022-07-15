package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"src/test/resources/Suites/Features"}, glue = {"steps"},
        monochrome = true, tags = "@accenture")

public class mainRunner extends AbstractTestNGCucumberTests {

}
