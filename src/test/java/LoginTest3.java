        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.testng.Assert;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;

public class LoginTest3 {
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

        Assert.assertTrue(loginPage.assertLoginPageIsLoaded(),"Login page is not loaded");

        loginPage.login("gdd0070@gmail.com","w19951491");

        HomePage homePage = new HomePage(webDriver);
        Assert.assertTrue(homePage.assertHomePageIsLoaded(),"Home page is not loaded");
    }

    @Test
    public void negativeLoginTestEmptyPassword() {
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.assertLoginPageIsLoaded(),"Login page is not loaded");

        loginPage.login("a@g.c","");

        Assert.assertTrue(loginPage.assertLoginPageIsLoaded(),"Login page is not loaded");
    }

    @Test
    public void negativeWrongPassword() {
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.assertLoginPageIsLoaded(),"Login page is not loaded");

        loginPage.login("gdd0070@gmail.com","g3434kd4");

        Assert.assertTrue(loginPage.assertLoginSubmitPageIsLoaded(),"Submit page is not loaded");
    }
}