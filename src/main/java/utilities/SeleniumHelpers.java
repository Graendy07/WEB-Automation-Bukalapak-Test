package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class SeleniumHelpers {
    WebDriver driver;
    JavaHelpers helper;
//    Actions actions;

    String os = System.getProperty("os.name").toLowerCase();

    public SeleniumHelpers(WebDriver driver)
    {
        this.driver = driver;
        helper = new JavaHelpers();
//        actions = new Actions(driver);
    }

    /**
     * Click on Element
     * @param e WebElement object
     * @throws InterruptedException
     */
    public void clickOn(WebElement e) throws InterruptedException
    {
        waitTillElementIsClickable(e).click();
        waitForJavascriptToLoad();
    }

    /**
     * Click on Element
     * @param by By object
     * @throws InterruptedException
     */
    public void clickOn(By by) throws InterruptedException
    {
        waitTillElementIsClickable(by).click();
        waitForJavascriptToLoad();
    }

    /**
     * To wait until element is clickable
     * @param by By object
     * @return WebElement object
     */
    public WebElement waitTillElementIsClickable(By by)
    {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }


    /**
     * Enter text to input field
     * @param e WebElement object
     * @param text input text
     * @param clear set true if want to clear field else set false
     */
    public void enterText(WebElement e, String text, boolean clear)
    {
        e = waitTillElementIsClickable(e);
        if(clear)
        {
            e.clear();
        }
        e.sendKeys(text);
    }

    //Page scrolls
    public WebElement pageScrollInView(WebElement e)
    {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",e);
        return e;
    }

    /**
     * Waiting before performing next action
     * @param seconds provide duration e.g. 1,2 etc
     * @throws InterruptedException
     */
    public void hardWait(int seconds) throws InterruptedException
    {
        Thread.sleep(seconds * 1000);
    }

    //Waits
    /**
     * To wait until element is clickable
     * @param e WebElement object
     * @return WebElement object
     */
    public WebElement waitTillElementIsClickable(WebElement e)
    {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(e));
        return e;
    }

    /** This function will wait for page to load (waiting for java script to finish loading) before moving further
     *
     * @paramWaitTime  Maximum time is the time out time. if the page loading completes before timeout, code will process
     * @throws InterruptedException
     */
    public  void waitForJavascriptToLoad() throws InterruptedException
    {
        Thread.sleep(1000);
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>()
        {
            public Boolean apply(WebDriver driver)
            {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
        };
        Wait<WebDriver> wait = new WebDriverWait(driver, 60);
        try
        {
            wait.until(expectation);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        catch(Error e)
        {
            e.printStackTrace();
        }
    }

    //Navigation
    public void navigateToPage(String url)
    {
        driver.get(url);
    }

    /**
     * Wait for specified duration and check if element is visible or not
     * @param e WebElement object
     * @param duration wait duration in seconds
     * @return WebElement if visible or null if not visible
     */
    public WebElement waitInCaseElementVisible(WebElement e, int duration)
    {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        try
        {
            return wait.until(ExpectedConditions.visibilityOf(e));
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    /**
     * Wait for specified duration and check if element is visible or not
     * @param by By object
     * @param duration wait duration in seconds
     * @return WebElement if visible or null if not visible
     */
    public WebElement waitInCaseElementVisible(By by, int duration)
    {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        try
        {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    /**
     * o wait until element is visible
     * @param e WebElement object
     * @param waitDurationInSeconds wait duration in seconds
     * @return WebElement object
     */
    public WebElement waitTillElementIsVisible(WebElement e, int waitDurationInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, waitDurationInSeconds);
        wait.until(ExpectedConditions.visibilityOf(e));
        return e;
    }

    //Java-script Helpers
    public void javascriptSetValue(WebElement e, String value)
    {
        String script = "arguments[0].value='" + value + "';";
        ((JavascriptExecutor) driver).executeScript(script, e);
    }

    public void javascriptClickOn(WebElement e)
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
    }

    /**
     * Verify element is displayed
     * @param el WebElement object
     * @return boolean
     */
    public Boolean isElementDisplayed(WebElement el)
    {
        try {
            el.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Browser's Tab handler
    public String getWindowHandle()
    {
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandles()
    {
        return driver.getWindowHandles();
    }

    public void switchToWindow(int tabNumber)
    {
        int i = 1;
        for (String winHandle : getWindowHandles())
        {
            driver.switchTo().window(winHandle);
            if (i == tabNumber)
                break;
            i++;
        }
    }

    /**
     * Get Text from field
     * @param e WebElement object
     * @return text from field
     */
    public String getText(WebElement e)
    {
        return waitTillElementIsVisible(e, 2).getText().trim();
    }

    public String getText(By object)
    {
        return driver.findElement(object).getText();
    }

    /**
     * Wait for specified duration and check if element is clickable or not
     * @param e WebElement object
     * @param duration wait duration in seconds
     * @return WebElement if clickable or null if not visible
     */
    public WebElement waitInCaseElementClickable(WebElement e, int duration)
    {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        try
        {
            return wait.until(ExpectedConditions.elementToBeClickable(e));
        }
        catch (Exception ex)
        {
            return null;
        }
    }

}
