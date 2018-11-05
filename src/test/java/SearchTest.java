import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

public class SearchTest {
    WebDriver webDriver;
    LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new FirefoxDriver();
        loginPage = new LoginPage(webDriver);
    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }

    /**
     * PreCondition:
     * - Open new Browser
     * - Navigate to linkedin.com
     *
     * Scenario:
     * - Verify that Login page is loaded.
     * - Login with valid credentials.
     * - Enter 'searchTerm' search field and press RETURN key.
     * - Verify that Search page is loaded.
     * - Verify 10 searchResults displayed on page.
     * - Verify each result item contains 'searchTerm'
     *
     * PostConditions:
     * - Close Browser.
     */
    @Test
    public void basicSearchTest() throws InterruptedException {
        /*Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        HomePage homePage = loginPage.login(userValidEmail, userValidPassword);

        Assert.assertTrue(homePage.homePageIsLoaded(),"Home page is not loaded.");

        SearchPage searchPage = homePage.setSearchTerm("Jack");

        sleep(5000);

        *//*JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("window.scrollBy(0,1000)", "");*//*

        Assert.assertTrue(searchPage.searchPageIsLoaded(), "Search page is not loaded.");

        Assert.assertTrue(searchPage.searchResultsIsLoaded(),"searchResults is not loaded.");

        List<WebElement> searchResults = searchPage.searchReultsFoundSearchTerm();
        for (WebElement searchResult:
             searchResults) {
            String searchResultText = searchResult.getText();
            Assert.assertTrue(searchResultText.contains(homePage.searchTerm),"SearchTerm \""+ homePage.searchTerm +"\" not found.");*/

            /*if (searchResults.size() > 0) {
                System.out.println("\nsearchTerm was found");
            }
            else {
                System.out.println("\nsearchTerm not found");
            }*/
        //medium application, android, хабл, medium
    }
}