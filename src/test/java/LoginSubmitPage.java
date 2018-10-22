import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmitPage {
    private WebDriver webDriver;

    private WebElement loginSubmitPageisLoaded;
    private WebElement messageInputCorrectEmail;

    public LoginSubmitPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements();
    }

    private void initElements() {
        loginSubmitPageisLoaded = webDriver.findElement(By.id("global-alert-queue"));
        messageInputCorrectEmail = webDriver.findElement(By.id("session_key-login-error"));
    }

    public boolean loginSubmitPageIsLoaded() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME")
                && webDriver.getTitle().equals("Войти в LinkedIn")
                && loginSubmitPageisLoaded.isDisplayed();
    }

    public boolean messageInputCorrectEmailisLoaded() {
        return messageInputCorrectEmail.isDisplayed();
    }
}
