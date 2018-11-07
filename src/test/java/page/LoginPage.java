package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id='login-submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id='login-email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//*[@id='login-password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//*[@id='layout-main']/div/div[1]/div/form/a")
    private WebElement resetPasswordButton;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        openLinkedinMainPage();
        PageFactory.initElements(webDriver,this);
    }

    public boolean loginPageIsLoaded() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/")
                && webDriver.getTitle().equals("LinkedIn: Войти или зарегистрироваться")
                && signInButton.isDisplayed();
    }

    public ForgotPasswordPage resetPassword() {
        resetPasswordButton.click();
        return new ForgotPasswordPage(webDriver);
    }

    public <T> T login(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(webDriver.getCurrentUrl().contains("/feed")) {
            return (T) new HomePage(webDriver);
        }
        if(webDriver.getCurrentUrl().contains("/uas/login-submit")) {
            return (T) new LoginSubmitPage(webDriver);
        }
        else {
            return (T) new LoginPage(webDriver);
        }
    }

    private void openLinkedinMainPage() {
        webDriver.get("https://www.linkedin.com/");
    }
}
