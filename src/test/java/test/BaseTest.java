package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LoginPage;

/**
 * PasswordEmail = "!John199514"
 */
public class BaseTest {
    private WebDriver webDriver;
    LoginPage loginPage;

    String userValidEmail = "test199514@gmail.com";
    String userValidLinkedinPassword = "!John199514";

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new FirefoxDriver();
        loginPage = new LoginPage(webDriver);
    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }
}