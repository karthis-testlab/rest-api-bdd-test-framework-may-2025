package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = "src/test/java/features/IncidentCreateRecord.feature:30",
		          glue = {"steps.def.som", "hooks"},
		          dryRun = false,
		          plugin = {
		        		  "html:reports/cucumber-report.html",
		        		  "rerun:failed-scenario.txt"
		          },
		          publish = false,
		          tags = ""
		         )
public class TestNgRunner extends AbstractTestNGCucumberTests {

}