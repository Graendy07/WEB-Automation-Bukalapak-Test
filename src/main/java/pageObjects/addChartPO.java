package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class addChartPO {

    WebDriver driver;
    SeleniumHelpers selenium;

    public addChartPO (WebDriver driver) {
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        // This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//button[@class='c-main-product__action__cart bl-button bl-button--outline bl-button--medium']")
    private WebElement chartButton;

    @FindBy(css = ".c-cart-dialog__cart-button")
    private WebElement lihatKeranjangButton;

    @FindBy (xpath = "//div[@class='p-20  mb-16 bl-card bl-card--outlined']//span[@class='bl-link is-contrast']")
    private WebElement hapusButton;

    @FindBy (xpath = "//internal-service[@id='vm__snackbar']")
    private WebElement removeChartToast;


    public void clickOnChartButton() throws InterruptedException{
        selenium.pageScrollInView(chartButton);
        selenium.waitTillElementIsVisible(chartButton, 3);
        selenium.javascriptClickOn(chartButton);
        selenium.hardWait(2);
    }

    public void clickOnLihatKeranjang() throws InterruptedException{
        selenium.waitTillElementIsVisible(lihatKeranjangButton, 2);
        selenium.clickOn(lihatKeranjangButton);
        selenium.hardWait(2);
    }

    public void clickOnHapusButton() throws InterruptedException {
        selenium.waitTillElementIsVisible(hapusButton, 2);
        selenium.clickOn(hapusButton);
    }

    public boolean verifyRemoveChart() {
        return selenium.waitInCaseElementVisible(removeChartToast, 5) != null;
    }

}
