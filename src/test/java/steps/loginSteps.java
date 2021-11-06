package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.loginPO;
import utilities.JavaHelpers;
import utilities.SeleniumDriver;


public class loginSteps {

    private WebDriver driver = SeleniumDriver.getDriver();
    private loginPO login = new loginPO(driver);

    //Data Properties
    private String dataTest = "src/test/resources/testData/data.properties";
    private String username = JavaHelpers.getPropertyValue(dataTest, "username_test");
    private String userPassword = JavaHelpers.getPropertyValue(dataTest, "password_test");
    private String bukalapakURL = JavaHelpers.getPropertyValue(dataTest, "bukalapak_url");

    @Given("user navigates to {string}")
    public void user_navigates_to_mamikos_staging(String type) throws InterruptedException {
        String url = "";
        if (type.equalsIgnoreCase("bukalapak web")) {
            url = bukalapakURL;
        }
        SeleniumDriver.openPage(url);
    }

    @When("user click on login button")
    public void user_click_on_login_button() throws InterruptedException
    {
        login.clickOnLoginButton();

    }


    @And("user login and enter as tenant via email as {string}")
    public void user_login_and_enter_as_tenant_via_phone_number_as(String type)throws InterruptedException {
        String email = "";
        String password = "";
        if (type.equalsIgnoreCase("user testing")) {
            email=username;
            password=userPassword;
        }
        login.loginUsingEmail(email,password);
    }

    @And("user log out from web")
    public void user_log_out_from_web()throws InterruptedException{
        login.clickOnAvatarButton();
        login.clickOLogOutButton();
    }

    @Then("user verify success login & toast message appear")
    public void user_verify_success_login_toast_message_appear() throws InterruptedException {
        Assert.assertTrue(login.verifyToastIndicator(), "Toast doesn't sent!");
    }

}
