package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        webDriver.get("https://www.linkedin.com/");

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "Login page URL is wrong.");

        WebElement userEmailField = webDriver.findElement(By.xpath("//*[@id='login-email']"));
        WebElement userPasswordField = webDriver.findElement(By.xpath("//*[@id='login-password']"));
        WebElement signInButton = webDriver.findElement(By.xpath("//*[@id='login-submit']"));

        String myEmail = "gdd0070@gmail.com";
        String myPassword = "";

        userEmailField.sendKeys(myEmail);
        userPasswordField.sendKeys(myPassword);
        signInButton.click();

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Home page URL is wrong.");

        webDriver.quit();
    }
}