package bigBasket;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/main/java/bigBasket/BigBasket.feature", glue = "steps", monochrome = true)

public class BigbasketRunner extends AbstractTestNGCucumberTests {
	
			

}
