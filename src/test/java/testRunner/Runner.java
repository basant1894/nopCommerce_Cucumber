package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
       (
        features=".//Features/Login.Feature",
        glue="stepDefinitions",
         //glue="C:\\Workspace6\\nopCommerce_Cucumber\\src\test\\java\\stepDefinitions\\Steps.java",
        dryRun=false,
        monochrome=true,
        plugin= {"pretty","html:test-output"}
		
		
		)

public class Runner {

}
