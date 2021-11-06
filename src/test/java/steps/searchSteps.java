package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.searchPO;
import utilities.SeleniumDriver;

public class searchSteps {

    private WebDriver driver = SeleniumDriver.getDriver();
    private searchPO search = new searchPO(driver);


    @And("user input & search product with value {string}")
    public void user_input_search_product_with_value(String name) throws InterruptedException {
        search.searchBar();
        search.insertProduct(name);
        search.clickOnSuggestProduct();
    }

    @And("user choose 1st product on the list {string}")
    public void user_choose_1st_product_on_the_list(String product) throws InterruptedException{
        search.chooseFirstProduct(product);
    }

    @And("verify product {string} added on chart")
    public void verify_product_added_on_chart(String productName) {
        Assert.assertTrue(search.verifyProduct(productName), "Seen kost didn't appear!");
    }
}
