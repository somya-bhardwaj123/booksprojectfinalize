package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = { "C:\\Users\\OWNER\\JDBC\\Seleniumworkspace\\BooksWagon\\src\\test\\java\\feature_e2e\\search.feature" }, glue = { "step_definition" },  monochrome = true, plugin = {
		"html:target/cucumber-html-report/cucumber.html"
		 })
public class TestRunner extends AbstractTestNGCucumberTests {

}
