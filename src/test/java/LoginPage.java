import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver webDriver;

    private WebElement signInButton;
    private WebElement userEmailField;
    private WebElement userPasswordField;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        openLinkedinMainPage();
        initElements();
    }

    public boolean loginPageIsLoaded() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/")
                && webDriver.getTitle().equals("LinkedIn: Войти или зарегистрироваться")
                && signInButton.isDisplayed();
    }

    private void initElements() {
        userEmailField = webDriver.findElement(By.id("login-email"));
        userPasswordField = webDriver.findElement(By.id("login-password"));
        signInButton = webDriver.findElement(By.id("login-submit"));
    }

    public void login(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
    }

    private void openLinkedinMainPage() {
        webDriver.get("https://www.linkedin.com/");
    }
}
