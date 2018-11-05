import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSubmitPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id='global-alert-queue']")
    private WebElement loginSubmitPageisLoaded;

    @FindBy(xpath = "//span[@id='session_key-login-error']")
    private WebElement messageInputCorrectEmail;

    @FindBy(xpath = "//span[@id='session_password-login-error']")
    private WebElement messageInputCorrectPassword;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement getAlertMessageText;

    public LoginSubmitPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public boolean loginSubmitPageIsLoaded() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME")
                && webDriver.getTitle().equals("Войти в LinkedIn")
                && loginSubmitPageisLoaded.isDisplayed();
    }

    public String messageInputCorrectEmailIsLoaded() {
        return messageInputCorrectEmail.getText();
    }

    public String messageInputCorrectPasswordIsLoaded() {
        return messageInputCorrectPassword.getText();
    }

    public String getAlertMessageTextIsLoaded() {
        return getAlertMessageText.getText();
    }
}
