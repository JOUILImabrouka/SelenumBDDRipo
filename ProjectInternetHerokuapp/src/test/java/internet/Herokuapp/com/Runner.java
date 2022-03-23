package internet.Herokuapp.com;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
monochrome=true,
		features={"src/test/resources/features"},
        //features={"src/test/resources/features/FormAuthenticationPage.feature"},
		glue= {"internet.Herokuapp.stepDefinitions"},

		plugin= {"pretty", "html:target/cucumber-report.html"},
		publish = true
		
		)


public class Runner {

}
