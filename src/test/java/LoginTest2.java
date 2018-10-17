import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest2 {
    WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new FirefoxDriver();
    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }


    /**
     * PreConditions:
     * Open FF browser.
     * Scenario:
     * - Navigate to http://linkedin.com/
     * - Verify that Login page is loaded
     * - Enter UserEmail into Username field
     * - Enter UserPassword into UserPassword field
     * - Click "Sign In" button
     * - Verify that home page is loaded.
     *
     * Postcondition:
     * - Close FF browser
     */
    @Test
    public void successfullLoginTest() {
        LoginPage loginPage = new LoginPage(webDriver);

        loginPage.assertLoginPage();

        loginPage.login("gdd0070@gmail.com","");

        loginPage.assertHomePage();
    }

    @Test
    public void negativeLoginTestEmptyPassword() {
        LoginPage loginPage = new LoginPage(webDriver);

        loginPage.assertLoginPage();

        loginPage.login("a@g.c","");

        loginPage.assertLoginPage();
    }

    @Test
    public void negativeLoginTestInvalidPassword() {
        LoginPage loginPage = new LoginPage(webDriver);

        loginPage.assertLoginPage();

        loginPage.login("gdd0070@gmail.com","qwsf1236");

        loginPage.assertLoginSubmitPage();
    }
}