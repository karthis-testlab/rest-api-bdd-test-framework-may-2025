package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/IncidentCreateRecord.feature",
        glue = "step.defs",
        dryRun = false,
        plugin = {
      		  "html:reports/cucumber-report.html",
      		  "rerun:failed-scenario.txt"
        },
        publish = false
       )
public class ParrallelTestRun extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {		
		return super.scenarios();
	}

}