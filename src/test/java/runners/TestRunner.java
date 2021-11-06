package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"steps"},
        monochrome = true,
        tags = "@AllTesting",
        plugin = {"pretty","html:target/report/cucumber.html"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
