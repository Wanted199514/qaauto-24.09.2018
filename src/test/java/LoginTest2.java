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
        webDriver.get("https://www.linkedin.com/");
        LoginPage loginPage = new LoginPage(webDriver);

        loginPage.assertLoginPage();

        loginPage.initElements();

        loginPage.login("gdd0070@gmail.com","");

        loginPage.assertHomePage();
    }

    @Test
    public void negativeLoginTest() {
        webDriver.get("https://www.linkedin.com/");
        LoginPage incorrectLoginPage = new LoginPage(webDriver);

        incorrectLoginPage.assertLoginPage();

        incorrectLoginPage.login("a@g.c","");

        incorrectLoginPage.assertLoginPage();
    }
}