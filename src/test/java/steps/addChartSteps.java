package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.addChartPO;
import utilities.SeleniumDriver;

public class addChartSteps {

    private WebDriver driver = SeleniumDriver.getDriver();
    private addChartPO addChart = new addChartPO(driver);


    @And("user add product to chart")
    public void user_add_product_to_chart() throws InterruptedException {
        addChart.clickOnChartButton();
        addChart.clickOnLihatKeranjang();
    }

    @And("user delete product from chart")
    public void user_delete_product_from_chart() throws InterruptedException{
        addChart.clickOnHapusButton();
    }

    @Then("validate the product is removed")
    public void validate_the_product_is_removed() throws InterruptedException {
        Assert.assertTrue(addChart.verifyRemoveChart(), "Chart doesn't remove!");
    }
}
