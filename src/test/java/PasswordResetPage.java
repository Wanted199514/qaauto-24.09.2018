import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordResetPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id='newPassword']")
    private WebElement newPasswordTerm;

    @FindBy(xpath = "//*[@id='confirmPassword']")
    private WebElement confirmPasswordTerm;

    @FindBy(xpath = "//*[@id='confirm-password-reset-form']/h2")
    private WebElement confirmPasswordResetForm;

    @FindBy(xpath = "//*[@id='reset-password-submit-button']")
    private WebElement resetPasswordButton;

    public PasswordResetPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public boolean passwordResetPageIsLoaded() {
        return webDriver.getCurrentUrl().contains("https://www.linkedin.com/checkpoint/rp/password-reset?requestSubmissionId=")
                && webDriver.getTitle().equals("Изменить пароль | LinkedIn")
                && confirmPasswordResetForm.isDisplayed();
    }


    public CheckpointSucessfulChangePasswordPage createNewPassword(String newPassword, String confirmPassword) {
        newPasswordTerm.sendKeys(newPassword);
        confirmPasswordTerm.sendKeys(confirmPassword);
        resetPasswordButton.click();
        return new CheckpointSucessfulChangePasswordPage(webDriver);
    }
}
