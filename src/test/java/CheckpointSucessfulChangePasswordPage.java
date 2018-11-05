import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckpointSucessfulChangePasswordPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id='app__container']/div[1]/header")
    private WebElement messageSucessfulPasswordChange;

    @FindBy(xpath = "//*[@id='reset-password-submit-button']")
    private WebElement returnToHomePageButton;

    public CheckpointSucessfulChangePasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public boolean checkpointSucessfulPasswordPageIsLoaded() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/checkpoint/rp/password-reset-submit")
                && webDriver.getTitle().equals("Вы изменили свой пароль. | LinkedIn")
                && messageSucessfulPasswordChange.isDisplayed();
    }

    public HomePage returnToHomePage() {
        returnToHomePageButton.click();
        return new HomePage(webDriver);
    }
}
