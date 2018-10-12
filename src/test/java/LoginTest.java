import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

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
        WebDriver webDriver = new FirefoxDriver();
        webDriver.navigate().to("https://www.linkedin.com/");

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "Home page URL is wrong.");


        webDriver.quit();
    }
}