package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = "src/test/java/features/IncidentCreateRecord.feature",
		          glue = "step.defs",
		          dryRun = false,
		          plugin = {
		        		  "html:reports/cucumber-report.html"
		          },
		          publish = false
		         )
public class TestNgRunner extends AbstractTestNGCucumberTests {

}