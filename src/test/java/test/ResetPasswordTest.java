package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

public class ResetPasswordTest extends BaseTest {

    @Test
    public void resetPasswordSuccessful() {
        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        ForgotPasswordPage forgotPasswordPage = loginPage.resetPassword();

        Assert.assertTrue(forgotPasswordPage.forgotPasswordPageIsLoaded(),"Forgot Password Page is not loaded.");

        CheckpointPage checkpointPage = forgotPasswordPage.emailTerm(userValidEmail);

        Assert.assertTrue(checkpointPage.checkpointPageIsLoaded(),"Checkpoint Page is not loaded.");

        checkpointPage.resendUrl();

        PasswordResetPage passwordResetPage = checkpointPage.openURL();

        Assert.assertTrue(passwordResetPage.passwordResetPageIsLoaded(),"Password reset page is not loaded.");

        CheckpointSucessfulChangePasswordPage checkpointSucessfulChangePasswordPage = passwordResetPage.createNewPassword(userValidLinkedinPassword, userValidLinkedinPassword);

        Assert.assertTrue(checkpointSucessfulChangePasswordPage.checkpointSucessfulPasswordPageIsLoaded(),"Checkpoint sucessful password page is not loaded.");

        HomePage homePage = checkpointSucessfulChangePasswordPage.returnToHomePage();

        Assert.assertTrue(homePage.homePageIsLoaded(),"Home page is not loaded.");
    }
}