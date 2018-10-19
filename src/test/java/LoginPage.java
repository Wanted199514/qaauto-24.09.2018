import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
    private WebDriver webDriver;

    private WebElement signInButton;
    private WebElement userEmailField;
    private WebElement userPasswordField;
    private WebElement me;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        openLinkedinMainPage();
        initElements();
    }

    public boolean assertLoginPageIsLoaded() {
        /*Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "Login page URL is wrong.");
        Assert.assertEquals(webDriver.getTitle(),"LinkedIn: Войти или зарегистрироваться",
                "Login page title is wrong.");
        Assert.assertTrue(signInButton.isDisplayed(),"SignIn is not displayed on Login page.");*/
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/")
                && webDriver.getTitle().equals("LinkedIn: Войти или зарегистрироваться")
                && signInButton.isDisplayed();
    }

    public boolean assertLoginSubmitPageIsLoaded() {
        Assert.assertEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME",
                "Login Submit page URL is wrong.");
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME");
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
