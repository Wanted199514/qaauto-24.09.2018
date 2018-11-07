package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

import static java.lang.Thread.sleep;

public class ResetPasswordTest extends BaseTest {

    @Test
    public void resetPasswordSuccessful() throws InterruptedException {
        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        ForgotPasswordPage forgotPasswordPage = loginPage.resetPassword();

        Assert.assertTrue(forgotPasswordPage.forgotPasswordPageIsLoaded(),"Forgot Password Page is not loaded.");

        CheckpointPage checkpointPage = forgotPasswordPage.emailTerm(userValidEmail);

        Assert.assertTrue(checkpointPage.checkpointPageIsLoaded(),"Checkpoint Page is not loaded.");

        PasswordResetPage passwordResetPage = checkpointPage.recendUrl();

        //sleep(30000);

        Assert.assertTrue(passwordResetPage.passwordResetPageIsLoaded(),"Password reset page is not loaded.");

        CheckpointSucessfulChangePasswordPage checkpointSucessfulChangePasswordPage = passwordResetPage.createNewPassword(userValidPassword, userValidPassword);

        Assert.assertTrue(checkpointSucessfulChangePasswordPage.checkpointSucessfulPasswordPageIsLoaded(),"Checkpoint sucessful password page is not loaded.");

        HomePage homePage = checkpointSucessfulChangePasswordPage.returnToHomePage();

        Assert.assertTrue(homePage.homePageIsLoaded(),"Home page is not loaded.");
    }
}