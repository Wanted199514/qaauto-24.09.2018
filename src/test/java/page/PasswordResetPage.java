package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordResetPage extends BasePage {

    @FindBy(xpath = "//*[@id='newPassword']")
    private WebElement newPasswordTerm;

    @FindBy(xpath = "//*[@id='confirmPassword']")
    private WebElement confirmPasswordTerm;

    @FindBy(xpath = "//*[@id='confirm-password-reset-form']/h2")
    private WebElement confirmPasswordResetForm;

    @FindBy(xpath = "//*[@id='reset-password-submit-button']")
    private WebElement resetPasswordButton;

    /**
     * Initialization of page elements
     * @param webDriver
     */
    public PasswordResetPage(WebDriver webDriver) {
        initialization(webDriver);
    }

    /**
     * check if this page is loaded
     * @return
     */
    public boolean passwordResetPageIsLoaded() {
        return webDriver.getCurrentUrl().contains("https://www.linkedin.com/checkpoint/rp/password-reset?requestSubmissionId=")
                && webDriver.getTitle().equals("Изменить пароль | LinkedIn")
                && confirmPasswordResetForm.isDisplayed();
    }


    /**
     * create new password
     * @param newPassword
     * @param confirmPassword
     * @return
     */
    public CheckpointSucessfulChangePasswordPage createNewPassword(String newPassword, String confirmPassword) {
        newPasswordTerm.sendKeys(newPassword);
        confirmPasswordTerm.sendKeys(confirmPassword);
        resetPasswordButton.click();
        return new CheckpointSucessfulChangePasswordPage(webDriver);
    }
}
