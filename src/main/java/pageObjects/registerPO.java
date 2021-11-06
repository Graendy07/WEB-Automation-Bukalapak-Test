package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class registerPO {

    WebDriver driver;
    SeleniumHelpers selenium;

    public registerPO (WebDriver driver) {
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        // This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }


    @FindBy(xpath = "//p[.='Daftar']")
    private WebElement daftarButton;

    @FindBy(xpath = "//input[@class='bl-text-field__input']")
    private WebElement inputEmailField;

    @FindBy (xpath = "//button[@class='bl-button bl-button--primary bl-button--medium bl-button--block']")
    private WebElement lanjutDaftarButton;

    @FindBy (xpath = "//p[@class='bl-text bl-text--caption bl-text--error']")
    private WebElement warningMessage;

    @FindBy (css = ".mb-8")
    private WebElement sendOTPButton;

    @FindBy (css = ".bl-text--error")
    private WebElement warningOTPMessage;

    @FindBy (css = "[aria-label='Kode rahasia']")
    private WebElement inputOTP;

    @FindBy (xpath = "//button[contains(.,'Verifikasi')]")
    private WebElement verifikasiButton;


    public void clickOnDaftarButton() throws InterruptedException {
        selenium.waitInCaseElementVisible(daftarButton,3);
        selenium.hardWait(3);
        selenium.clickOn(daftarButton);
    }


    public void inputRegistEmail(String akun) throws InterruptedException {
        selenium.enterText(inputEmailField, akun, false);
        selenium.clickOn(lanjutDaftarButton);
    }


    public boolean verifyWrongEmail() {
        return selenium.waitInCaseElementVisible(warningMessage, 5) != null;
    }


    public void clickOnSendOTP() throws InterruptedException {
        selenium.waitInCaseElementVisible(sendOTPButton,3);
        selenium.hardWait(3);
        selenium.clickOn(sendOTPButton);
    }


    public void inputOTP(String otp) throws InterruptedException {
        selenium.enterText(inputOTP, otp, false);
        selenium.clickOn(verifikasiButton);
    }


    public boolean verifyWrongOTP() {
        return selenium.waitInCaseElementVisible(warningOTPMessage, 5) != null;
    }

}
