package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class searchPO {

    WebDriver driver;
    SeleniumHelpers selenium;

    public searchPO (WebDriver driver) {
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        // This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(id = "v-omnisearch__input")
    private WebElement searchBar;

    @FindBy(xpath = "//span[.='dalam Semua Kategori']")
    private WebElement resultSearch;

    @FindBy(xpath = "//img[@alt='OBRAL MURAH LCD MONITOR 19 INC WIDE SCREEN MULUS BERGARANSI']")
    private WebElement firstProduct;


    public void searchBar() throws InterruptedException{
        selenium.clickOn(searchBar);
    }


    public void insertProduct(String name) throws InterruptedException {
        selenium.enterText(searchBar, name, false);
        selenium.hardWait(3);
    }

    public void clickOnSuggestProduct() throws InterruptedException{
        selenium.waitTillElementIsVisible(resultSearch, 2);
        selenium.clickOn(resultSearch);
        selenium.hardWait(3);
    }


    public void chooseFirstProduct(String product) throws InterruptedException{
        WebElement element = driver.findElement(By.xpath("//img[@alt='"+product+"']"));
        selenium.waitTillElementIsVisible(element, 3);
        selenium.javascriptClickOn(element);
        selenium.hardWait(3);
    }


    public boolean verifyProduct(String productName) {
        WebElement element = driver.findElement(By.xpath("//*[text()[contains(., '"+productName+"')]]"));
        return selenium.waitInCaseElementVisible(element, 5) != null;
    }


}
