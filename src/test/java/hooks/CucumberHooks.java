package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class CucumberHooks {
	
	@Before
	public void runBeforeEachScenario(Scenario scenario) {
		System.out.println("Before Scenario: "+scenario.getName());
	}
	
	@After
	public void runAfterEachScenario(Scenario scenario) {
		System.out.println("After Scenario: "+scenario.getName());
	}
	
	@BeforeStep
	public void runBeforeEachStep() {
		
	}
	
	@AfterStep
	public void reunAfterEachStep() {
		
	}
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("Before All Scenarios");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("After All Scenarios");
	}

}