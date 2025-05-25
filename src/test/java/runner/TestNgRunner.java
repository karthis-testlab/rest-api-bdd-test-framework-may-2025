package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = "src/test/java/features/IncidentCreateRecord.feature",
		          glue = {"step.defs", "hooks"},
		          dryRun = false,
		          plugin = {
		        		  "html:reports/cucumber-report.html",
		        		  "rerun:failed-scenario.txt"
		          },
		          publish = false,
		          tags = "not @smoke"
		         )
public class TestNgRunner extends AbstractTestNGCucumberTests {

}