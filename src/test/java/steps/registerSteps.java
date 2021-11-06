package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.registerPO;
import utilities.SeleniumDriver;

public class registerSteps {

    private WebDriver driver = SeleniumDriver.getDriver();
    private registerPO register = new registerPO(driver);

    @When("user click on register button")
    public void user_click_on_register_button() throws InterruptedException
    {
        register.clickOnDaftarButton();
    }

    @And("user register using wrong email {string}")
    public void user_register_using_wrong_email(String akun)throws InterruptedException {
        register.inputRegistEmail(akun);
    }

    @Then("user verify input wrong email")
    public void user_verify_input_wrong_email() throws InterruptedException {
        Assert.assertTrue(register.verifyWrongEmail(), "warning message doesn't appear!");
    }

    @And("user register using valid email")
    public void user_register_using_valid_email()throws InterruptedException {
        register.inputRegistEmail("himellmez.dn@gmail.com");
        register.clickOnSendOTP();
    }

    @And("user input wrong OTP {string}")
    public void user_input_wrong_OTP(String otp)throws InterruptedException {
        register.inputOTP(otp);
    }

    @Then("user verify the wrong OTP")
    public void user_verify_the_wrong_OTP() throws InterruptedException {
        Assert.assertTrue(register.verifyWrongOTP(), "warning message doesn't appear!");
    }

}
