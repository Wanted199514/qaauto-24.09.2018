        import org.openqa.selenium.By;
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

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        loginPage.login("gdd0070@gmail.com","");

        HomePage homePage = new HomePage(webDriver);
        Assert.assertTrue(homePage.homePageIsLoaded(),"Home page is not loaded.");
    }

    @Test
    public void negativeLoginTestEmptyPassword() {
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        loginPage.login("a@g.c","");

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");
    }

    @Test
    public void negativeWrongPassword() {
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        loginPage.login("gdd0070@gmail.com","g3434kd4");

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(webDriver);
        Assert.assertTrue(loginSubmitPage.loginSubmitPageIsLoaded(),"Submit page is not loaded.");
        Assert.assertTrue(webDriver.findElement(By.id("session_password-login-error")).isDisplayed(),
                "Message 'Это неверный пароль. Повторите попытку или измените пароль.' is not loaded");
    }

    @Test
    public void negativeEmptyEmail() {
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        loginPage.login("","");

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");
    }

    @Test
    public void negativeWrongEmail() {
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        loginPage.login("a@g.c","");

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(webDriver);
        Assert.assertTrue(loginSubmitPage.loginSubmitPageIsLoaded(),"Submit page is not loaded.");
        Assert.assertTrue(loginSubmitPage.messageInputCorrectEmailisLoaded(),
                "Message 'Укажите действительный адрес эл. почты.' is not loaded");
    }

    @Test
    public void negativeWrongSyntaxEmail() {
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        loginPage.login("ladfhlalf","");

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(webDriver);
        Assert.assertTrue(loginSubmitPage.loginSubmitPageIsLoaded(),"Submit page is not loaded.");
        Assert.assertTrue(loginSubmitPage.messageInputCorrectEmailisLoaded(),
                "Message 'Укажите действительный адрес эл. почты.' is not loaded");
    }

    @Test
    public void negativeWrongSyntaxEmailOnlyNumbers() {
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        loginPage.login("3124241234","");

        CaptchaPage captchaPage = new CaptchaPage(webDriver);
        Assert.assertTrue(captchaPage.captchaPageIsLoaded(),"Captcha page is not loaded.");
    }

    @Test
    public void negativeWrongSyntaxPasswordOnlyNumbers() {
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        loginPage.login("gdd0070@gmail.com","1423412346");

        CaptchaPage captchaPage = new CaptchaPage(webDriver);
        Assert.assertTrue(captchaPage.captchaPageIsLoaded(),"Captcha page is not loaded.");
    }

    @Test
    public void negativeEmailBoundariesMax128() {
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        loginPage.login("ghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvb",
                "");

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(webDriver);
        Assert.assertTrue(loginSubmitPage.loginSubmitPageIsLoaded(),"Submit page is not loaded.");
        Assert.assertTrue(loginSubmitPage.messageInputCorrectEmailisLoaded(),
                "Message 'Укажите действительный адрес эл. почты.' is not loaded");
    }

    @Test
    public void negativeEmailBoundariesMoreMax128() {
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        loginPage.login("asdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfe",
                "");

        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(webDriver);
        Assert.assertTrue(loginSubmitPage.loginSubmitPageIsLoaded(),"Submit page is not loaded.");
        Assert.assertTrue(loginSubmitPage.messageInputCorrectEmailisLoaded(),
                "Message 'Слишком длинный текст: максимальная длина – 128 симв., введено 140 симв.' is not loaded");
    }
}