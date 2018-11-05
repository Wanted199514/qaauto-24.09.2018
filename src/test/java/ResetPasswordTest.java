import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class ResetPasswordTest {
    WebDriver webDriver;
    LoginPage loginPage;

    String userValidEmail = "gdd0070@gmail.com";
    String usernewPassword = "";

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new FirefoxDriver();
        loginPage = new LoginPage(webDriver);
    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }

    @Test
    public void resetPasswordSuccessful() throws InterruptedException {
        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        ForgotPasswordPage forgotPasswordPage = loginPage.resetPassword();

        sleep(3000);

        Assert.assertTrue(forgotPasswordPage.forgotPasswordPageIsLoaded(),"Forgot Password Page is not loaded.");

        CheckpointPage checkpointPage = forgotPasswordPage.emailTerm(userValidEmail);

        sleep(3000);

        Assert.assertTrue(checkpointPage.checkpointPageIsLoaded(),"Checkpoint Page is not loaded.");

        checkpointPage.recendUrl();

        sleep(30000);

        PasswordResetPage passwordResetPage = new PasswordResetPage(webDriver);

        Assert.assertTrue(passwordResetPage.passwordResetPageIsLoaded(),"Password reset page is not loaded.");

        CheckpointSucessfulChangePasswordPage checkpointSucessfulChangePasswordPage = passwordResetPage.createNewPassword(usernewPassword, usernewPassword);

        sleep(3000);

        Assert.assertTrue(checkpointSucessfulChangePasswordPage.checkpointSucessfulPasswordPageIsLoaded(),"Checkpoint sucessful password page is not loaded.");

        HomePage homePage = checkpointSucessfulChangePasswordPage.returnToHomePage();

        sleep(3000);

        Assert.assertTrue(homePage.homePageIsLoaded(),"Home page is not loaded.");
    }
}