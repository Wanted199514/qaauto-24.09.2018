        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.testng.Assert;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.DataProvider;
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

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "gdd0070@gmail.com", "w19951491" },
                { "GDD0070@gmail.com", "w19951491" },
                { " gdd0070@gmail.com ", "w19951491" }
        };
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
    @Test(dataProvider = "validDataProvider")
    public void successfullLoginTest(String userEmail, String userPassword) {
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        HomePage homePage = loginPage.login(userEmail, userPassword);

        Assert.assertTrue(homePage.homePageIsLoaded(),"Home page is not loaded.");
    }

    @Test
    public void negativeLoginTestEmptyPassword() {
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        loginPage.login("a@g.c", "");

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");
    }

    @Test
    public void negativeWrongPassword() {
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        LoginSubmitPage loginSubmitPage = loginPage.login("gdd0070@gmail.com","g3434kd4");

        Assert.assertTrue(loginSubmitPage.loginSubmitPageIsLoaded(),"Submit page is not loaded.");
        Assert.assertTrue(loginSubmitPage.messageInputCorrectPasswordIsLoaded(),
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

        LoginSubmitPage loginSubmitPage = loginPage.login("a@g.c","");

        Assert.assertTrue(loginSubmitPage.loginSubmitPageIsLoaded(),"Submit page is not loaded.");
        Assert.assertTrue(loginSubmitPage.messageInputCorrectEmailIsLoaded(),
                "Message 'Укажите действительный адрес эл. почты.' is not loaded");
    }

    @Test
    public void negativeWrongSyntaxEmail() {
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        LoginSubmitPage loginSubmitPage = loginPage.login("ladfhlalf","");

        Assert.assertTrue(loginSubmitPage.loginSubmitPageIsLoaded(),"Submit page is not loaded.");
        Assert.assertTrue(loginSubmitPage.messageInputCorrectEmailIsLoaded(),
                "Message 'Укажите действительный адрес эл. почты.' is not loaded");
    }

    @Test
    public void negativeEmailBoundariesMax128() {
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        LoginSubmitPage loginSubmitPage = loginPage.login("ghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvb",
                "");

        Assert.assertTrue(loginSubmitPage.loginSubmitPageIsLoaded(),"Submit page is not loaded.");
        Assert.assertTrue(loginSubmitPage.messageInputCorrectEmailIsLoaded(),
                "Message 'Укажите действительный адрес эл. почты.' is not loaded");
    }

    @Test
    public void negativeEmailBoundariesMoreMax128() {
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        LoginSubmitPage loginSubmitPage = loginPage.login("asdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfe",
                "");

        Assert.assertTrue(loginSubmitPage.loginSubmitPageIsLoaded(),"Submit page is not loaded.");
        Assert.assertTrue(loginSubmitPage.messageInputCorrectEmailIsLoaded(),
                "Message 'Слишком длинный текст: максимальная длина – 128 симв., введено 140 симв.' is not loaded");
    }

    @Test
    public void negativePasswordBoundariesMoreMax128() {
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        LoginSubmitPage loginSubmitPage = loginPage.login("gdd0070@gmail.com",
                "asdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfe");

        Assert.assertTrue(loginSubmitPage.loginSubmitPageIsLoaded(),"Submit page is not loaded.");
        Assert.assertTrue(loginSubmitPage.messageInputCorrectPasswordIsLoaded(),
                "Message 'Это неверный пароль. Повторите попытку или измените пароль.' is not loaded");
    }

    @Test
    public void negativePasswordBoundariesMax128() {
        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        LoginSubmitPage loginSubmitPage = loginPage.login("gdd0070@gmail.com",
                "ghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvb");

        Assert.assertTrue(loginSubmitPage.loginSubmitPageIsLoaded(),"Submit page is not loaded.");
        Assert.assertTrue(loginSubmitPage.messageInputCorrectPasswordIsLoaded(),
                "Message 'Это неверный пароль. Повторите попытку или измените пароль.' is not loaded");
    }
}