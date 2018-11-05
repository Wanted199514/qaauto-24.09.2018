import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id='app__container']/div[1]/header")
    private WebElement findYourProfile;

    @FindBy(xpath = "//*[@id='username']")
    private WebElement inputyourEmailTerm;

    @FindBy(xpath = "//*[@id='reset-password-submit-button']")
    private WebElement searchProfileButton;

    public ForgotPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public boolean forgotPasswordPageIsLoaded() {
        return webDriver.getCurrentUrl().contains("https://www.linkedin.com/uas/request-password-reset")
                && webDriver.getTitle().equals("Изменить пароль | LinkedIn")
                && findYourProfile.isDisplayed();
    }

    public CheckpointPage emailTerm(String inputYourEmail) {
        inputyourEmailTerm.sendKeys(inputYourEmail);
        searchProfileButton.click();
        return new CheckpointPage(webDriver);
    }
}
