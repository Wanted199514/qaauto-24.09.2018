package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchPage;

import java.util.List;

public class SearchTest2 extends BaseTest {

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
    public void basicSearchTest() {
        String searchTerm = "Jack";

        Assert.assertTrue(loginPage.loginPageIsLoaded(),"Login page is not loaded.");

        HomePage homePage = loginPage.login(userValidEmail, userValidLinkedinPassword);

        Assert.assertTrue(homePage.homePageIsLoaded(),"Home page is not loaded.");

        SearchPage searchPage = homePage.setSearchTerm(searchTerm);

        Assert.assertTrue(searchPage.searchPageIsLoaded(), "Search page is not loaded.");

        Assert.assertEquals(searchPage.searchResultsIsLoaded(), 10,"searchResults count is wrong.");

        List<String> searchResultsList = searchPage.getSearchResults();

        for (String searchResult:
             searchResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm \""+ searchTerm +"\" not found in "+searchPage.searchResultsIsLoaded()+".");
        }
    }
}
