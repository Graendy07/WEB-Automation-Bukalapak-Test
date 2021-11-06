package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.SeleniumDriver;

public class Hooks {

    @Before
    public static void setUp() {
        //ExtentCucumberFormatter.initiateExtentCucumberFormatter();
        System.out.println("Before");
        SeleniumDriver.setUpDriver();
    }

    @After
    public static void tearDown(Scenario scenario) {

        WebDriver driver=SeleniumDriver.getDriver();
        System.out.println(scenario.isFailed());
        if (scenario.isFailed()) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png", "image");
        }
        SeleniumDriver.tearDown();
    }

}
