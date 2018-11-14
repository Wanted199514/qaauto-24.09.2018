package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckpointSucessfulChangePasswordPage extends BasePage {

    @FindBy(xpath = "//*[@id='app__container']/div[1]/header")
    private WebElement messageSucessfulPasswordChange;

    @FindBy(xpath = "//*[@id='reset-password-submit-button']")
    private WebElement returnToHomePageButton;

    /**
     * Initialization of page elements
     * @param webDriver
     */
    public CheckpointSucessfulChangePasswordPage(WebDriver webDriver) {
        initialization(webDriver);
    }

    /**
     * check if this page is loaded
     * @return
     */
    public boolean checkpointSucessfulPasswordPageIsLoaded() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/checkpoint/rp/password-reset-submit")
                && webDriver.getTitle().equals("Вы изменили свой пароль. | LinkedIn")
                && messageSucessfulPasswordChange.isDisplayed();
    }

    /**
     * click the button to get to the home page
     * @return
     */
    public HomePage returnToHomePage() {
        returnToHomePageButton.click();
        return new HomePage(webDriver);
    }
}
