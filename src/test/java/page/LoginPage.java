package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id='login-submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id='login-email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//*[@id='login-password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//*[@id='layout-main']/div/div[1]/div/form/a")
    private WebElement resetPasswordButton;

    /**
     * open the website of linkedin and initialize the page elements
     * @param webDriver
     */
    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        openLinkedinMainPage();
        PageFactory.initElements(webDriver,this);
    }

    /**
     * check if this page is loaded
     * @return check "https://www.linkedin.com/"/"LinkedIn: Войти или зарегистрироваться"/"Sign In" button
     */
    public boolean loginPageIsLoaded() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/")
                && webDriver.getTitle().equals("LinkedIn: Войти или зарегистрироваться")
                && signInButton.isDisplayed();
    }

    /**
     * Method is click on "Reset password" button
     * @return either ForgotPasswordPage object
     */
    public ForgotPasswordPage resetPassword() {
        resetPasswordButton.click();
        return new ForgotPasswordPage(webDriver);
    }

    /**
     * Method that logs in with specific credentials
     * @param userEmail - String with userEmail
     * @param userPassword - String with userPassword
     * @param <T> - generic type to cast different Page Objects
     * @return either HomePage/LoginSubmitPage/LoginPage object
     */
    public <T> T login(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
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

    /**
     * Linkedin Link
     */
    private void openLinkedinMainPage() {
        webDriver.get("https://www.linkedin.com/");
    }
}
