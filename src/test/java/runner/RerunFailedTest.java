package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = "@failed-scenario.txt",
		          glue = "step.defs"
		        )
public class RerunFailedTest extends AbstractTestNGCucumberTests {

}