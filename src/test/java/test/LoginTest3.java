package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginSubmitPage;

public class LoginTest3 extends BaseTest {

    @DataProvider
    public Object[][] validationMessagesCombinations() {
        String userValidEMail = this.userValidEmail;
        String userValidPassword = this.userValidPassword;
        return new Object[][]{
                { userValidEMail, userValidPassword },
                { "GDD0070@gmail.com", userValidPassword },
                { " " + userValidEMail + " ", userValidPassword }
        };
    }

    @DataProvider
    public Object[][] negativeValidDataProviderLoginSubmitPage() {
        String userValidEMail = this.userValidEmail;
        String userValidPassword = this.userValidPassword;
        String emailValidationMessage = "Укажите действительный адрес эл. почты.";
        String passwordValidationMessage = "Это неверный пароль. Повторите попытку или измените пароль.";
        return new Object[][]{
                { userValidEMail, "g3434kd4", emailValidationMessage, passwordValidationMessage },
                { "a@g.c", userValidPassword, emailValidationMessage, passwordValidationMessage },
                { "ladfhlalf", userValidPassword, emailValidationMessage, passwordValidationMessage },
                { "ghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvb", userValidPassword, emailValidationMessage, passwordValidationMessage },
                { "asdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfe", userValidPassword, emailValidationMessage, passwordValidationMessage },
                { userValidEMail, "asdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfe", emailValidationMessage, passwordValidationMessage },
                { userValidEMail, "ghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvb", emailValidationMessage, passwordValidationMessage }
        };
    }

    @DataProvider
    public Object[][] negativeValidDataProviderLoginPage() {
        return new Object[][]{
                { "a@g.c", "" },
                { "", "jdlajdl" }
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
    @Test(dataProvider = "validationMessagesCombinations")
    public void successfullLoginTest(String userEmail, String userPassword) {
        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        HomePage homePage = loginPage.login(userEmail, userPassword);

        Assert.assertTrue(homePage.homePageIsLoaded(),"Home page is not loaded.");
    }

    @Test(dataProvider = "negativeValidDataProviderLoginSubmitPage")
    public void validationMessagesInvalidEmailPasswordTest(String userEmail, String userPassword, String emailValidationMessage, String passwordValidationMessage) {
        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        LoginSubmitPage loginSubmitPage = loginPage.login(userEmail, userPassword);

        Assert.assertEquals(loginSubmitPage.getAlertMessageTextIsLoaded(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Submit page is not loaded.");

        Assert.assertEquals(loginSubmitPage.messageInputCorrectEmailIsLoaded(),
                emailValidationMessage, "Email validation message is wrong.");
        Assert.assertEquals(loginSubmitPage.messageInputCorrectPasswordIsLoaded(),
                passwordValidationMessage, "Password validation message is wrong.");
    }

    @Test(dataProvider = "negativeValidDataProviderLoginPage")
    public void negativeLoginTestLoginPage(String userEmail, String userPassword) {
        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        loginPage.login(userEmail, userPassword);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");
    }

    /*@Test
    public void negativeLoginTestEmptyPassword() {
        page.LoginPage loginPage = new page.LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        loginPage.login("a@g.c", "");

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");
    }

    @Test
    public void negativeWrongPassword() {
        page.LoginPage loginPage = new page.LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        page.LoginSubmitPage loginSubmitPage = loginPage.login("gdd0070@gmail.com","g3434kd4");

        Assert.assertTrue(loginSubmitPage.loginSubmitPageIsLoaded(),"Submit page is not loaded.");
        Assert.assertTrue(loginSubmitPage.messageInputCorrectPasswordIsLoaded(),
                "Message 'Это неверный пароль. Повторите попытку или измените пароль.' is not loaded");
    }

    @Test
    public void negativeEmptyEmail() {
        page.LoginPage loginPage = new page.LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        loginPage.login("","");

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");
    }

    @Test
    public void negativeWrongEmail() {
        page.LoginPage loginPage = new page.LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        page.LoginSubmitPage loginSubmitPage = loginPage.login("a@g.c","");

        Assert.assertTrue(loginSubmitPage.loginSubmitPageIsLoaded(),"Submit page is not loaded.");
        Assert.assertTrue(loginSubmitPage.messageInputCorrectEmailIsLoaded(),
                "Message 'Укажите действительный адрес эл. почты.' is not loaded");
    }

    @Test
    public void negativeWrongSyntaxEmail() {
        page.LoginPage loginPage = new page.LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        page.LoginSubmitPage loginSubmitPage = loginPage.login("ladfhlalf","");

        Assert.assertTrue(loginSubmitPage.loginSubmitPageIsLoaded(),"Submit page is not loaded.");
        Assert.assertTrue(loginSubmitPage.messageInputCorrectEmailIsLoaded(),
                "Message 'Укажите действительный адрес эл. почты.' is not loaded");
    }

    @Test
    public void negativeEmailBoundariesMax128() {
        page.LoginPage loginPage = new page.LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        page.LoginSubmitPage loginSubmitPage = loginPage.login("ghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvb",
                "");

        Assert.assertTrue(loginSubmitPage.loginSubmitPageIsLoaded(),"Submit page is not loaded.");
        Assert.assertTrue(loginSubmitPage.messageInputCorrectEmailIsLoaded(),
                "Message 'Укажите действительный адрес эл. почты.' is not loaded");
    }

    @Test
    public void negativeEmailBoundariesMoreMax128() {
        page.LoginPage loginPage = new page.LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        page.LoginSubmitPage loginSubmitPage = loginPage.login("asdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfe",
                "");

        Assert.assertTrue(loginSubmitPage.loginSubmitPageIsLoaded(),"Submit page is not loaded.");
        Assert.assertTrue(loginSubmitPage.messageInputCorrectEmailIsLoaded(),
                "Message 'Слишком длинный текст: максимальная длина – 128 симв., введено 140 симв.' is not loaded");
    }

    @Test
    public void negativePasswordBoundariesMoreMax128() {
        page.LoginPage loginPage = new page.LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        page.LoginSubmitPage loginSubmitPage = loginPage.login("gdd0070@gmail.com",
                "asdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfeasdwqasdfe");

        Assert.assertTrue(loginSubmitPage.loginSubmitPageIsLoaded(),"Submit page is not loaded.");
        Assert.assertTrue(loginSubmitPage.messageInputCorrectPasswordIsLoaded(),
                "Message 'Это неверный пароль. Повторите попытку или измените пароль.' is not loaded");
    }

    @Test
    public void negativePasswordBoundariesMax128() {
        page.LoginPage loginPage = new page.LoginPage(webDriver);

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        page.LoginSubmitPage loginSubmitPage = loginPage.login("gdd0070@gmail.com",
                "ghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvbnhghtyhgvb");

        Assert.assertTrue(loginSubmitPage.loginSubmitPageIsLoaded(),"Submit page is not loaded.");
        Assert.assertTrue(loginSubmitPage.messageInputCorrectPasswordIsLoaded(),
                "Message 'Это неверный пароль. Повторите попытку или измените пароль.' is not loaded");
    }*/
}