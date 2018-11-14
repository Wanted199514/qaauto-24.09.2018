package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

    @FindBy(xpath = "//*[@id='app__container']/div[1]/header")
    private WebElement findYourProfile;

    @FindBy(xpath = "//*[@id='username']")
    private WebElement inputYourEmailTerm;

    @FindBy(xpath = "//*[@id='reset-password-submit-button']")
    private WebElement searchProfileButton;

    /**
     * Initialization of page elements
     * @param webDriver
     */
    public ForgotPasswordPage(WebDriver webDriver) {
        initialization(webDriver);
    }

    /**
     * check if this page is loaded
     * @return
     */
    public boolean forgotPasswordPageIsLoaded() {
        return webDriver.getCurrentUrl().contains("https://www.linkedin.com/uas/request-password-reset")
                && webDriver.getTitle().equals("Изменить пароль | LinkedIn")
                && findYourProfile.isDisplayed();
    }

    /**
     * The field in which you need to write your email
     * @param inputYourEmail - text what we write in inputYourEmailTerm field
     * @return either CheckpointPage
     */
    public CheckpointPage emailTerm(String inputYourEmail) {
        inputYourEmailTerm.sendKeys(inputYourEmail);
        searchProfileButton.click();
        return new CheckpointPage(webDriver);
    }
}
