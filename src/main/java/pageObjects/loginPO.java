package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class loginPO {

    WebDriver driver;
    SeleniumHelpers selenium;

    public loginPO (WebDriver driver) {
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        // This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//p[.='Login']")
    private WebElement loginButton;


    @FindBy(className = "bl-text-field__input")
    private WebElement usernameField;

    @FindBy(xpath = "//button[@id='submit_button']")
    private WebElement lanjutButton;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordField;

    @FindBy (id = "btn-login")
    private WebElement submitPassword;

    @FindBy (xpath = "//div[@class='bl-avatar sigil-avatar']")
    private WebElement avatarButton;

    @FindBy (xpath = "//p[contains(.,'Logout')]")
    private WebElement logOutButton;

    @FindBy (xpath = "//div[@class='bl-snackbar is-active']/div[@class='bl-flex-container justify-space-between']")
    private WebElement loginToastMessage;


    public void clickOnLoginButton() throws InterruptedException {
            selenium.waitInCaseElementVisible(loginButton,3);
            selenium.hardWait(3);
            selenium.clickOn(loginButton);
    }


    public void loginUsingEmail(String email, String password) throws InterruptedException {
        selenium.enterText(usernameField, email, false);
        selenium.clickOn(lanjutButton);
        selenium.waitTillElementIsVisible(passwordField, 3);
        selenium.enterText(passwordField, password, false);
        selenium.clickOn(submitPassword);
        selenium.hardWait(3);
    }


    public void clickOnAvatarButton() throws InterruptedException {
        selenium.waitInCaseElementVisible(avatarButton,3);
        selenium.hardWait(3);
        selenium.clickOn(avatarButton);
    }


    public void clickOLogOutButton() throws InterruptedException {
        selenium.waitInCaseElementVisible(logOutButton,3);
        selenium.hardWait(3);
        selenium.clickOn(logOutButton);
    }


    public boolean verifyToastIndicator() {
        return selenium.waitInCaseElementVisible(loginToastMessage, 5) != null;
    }


}