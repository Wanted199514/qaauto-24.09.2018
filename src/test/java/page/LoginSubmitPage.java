package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginSubmitPage extends BasePage {

    @FindBy(xpath = "//*[@id='global-alert-queue']")
    private WebElement loginSubmitPageisLoaded;

    @FindBy(xpath = "//span[@id='session_key-login-error']")
    private WebElement messageInputCorrectEmail;

    @FindBy(xpath = "//span[@id='session_password-login-error']")
    private WebElement messageInputCorrectPassword;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement getAlertMessageText;

    /**
     * Initialization of page elements
     * @param webDriver
     */
    public LoginSubmitPage(WebDriver webDriver) {
        initialization(webDriver);
        waitUntilElementIsClickable(loginSubmitPageisLoaded);
    }

    /**
     * check if this page is loaded
     * @return
     */
    public boolean loginSubmitPageIsLoaded() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME")
                && webDriver.getTitle().equals("Войти в LinkedIn")
                && loginSubmitPageisLoaded.isDisplayed();
    }

    /**
     * check whether the message is entered incorrect input email
     * @return
     */
    public String messageInputCorrectEmailIsLoaded() {
        return messageInputCorrectEmail.getText();
    }

    /**
     * check whether the message is incorrect password entry
     * @return
     */
    public String messageInputCorrectPasswordIsLoaded() {
        return messageInputCorrectPassword.getText();
    }

    /**
     * check whether warning message is present
     * @return
     */
    public String getAlertMessageTextIsLoaded() {
        return getAlertMessageText.getText();
    }
}
