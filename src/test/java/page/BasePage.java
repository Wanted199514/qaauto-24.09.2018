package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GMailService;

/**
 * basic page methods
 */
public class BasePage {
    protected WebDriver webDriver;
    protected GMailService gMailService = new GMailService();

    /**
     * initialize elements on pages
     * @param webDriver
     */
    public void initialization(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver,this);
    }

    /**
     * waiting for a request for a certain period of time
     * @param webElement
     */
    public void waitUntilElementIsClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(webDriver,5);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
