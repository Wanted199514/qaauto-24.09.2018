package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//*[@class='ember-view']/header/div/div")
    protected WebElement filtersSearch;

    @FindBy(xpath = "//li[contains(@class, 'search-result__occluded-item')]")
    private List<WebElement> searchResults;

    /**
     * Initialization of page elements
     * @param webDriver
     */
    public SearchPage(WebDriver webDriver) {
        initialization(webDriver);
        waitUntilElementIsClickable(filtersSearch);
    }

    /**
     * check if this page is loaded
     * @return
     */
    public boolean searchPageIsLoaded() {
        return webDriver.getCurrentUrl().contains("https://www.linkedin.com/search/results/all/?keywords=")
                && webDriver.getTitle().contains(" | Поиск | LinkedIn")
                && filtersSearch.isDisplayed();
    }

    /**
     * check whether search results loaded
     * @return
     */
    public int searchResultsIsLoaded() {
        return searchResults.size();
    }

    /**
     * go through each search result
     * @return
     */
    public List<String> getSearchResults() {
        List<String> searchResultStringList = new ArrayList<String>();
        for (WebElement searchResult:
             searchResults) {
            ((JavascriptExecutor) webDriver)
                    .executeScript("arguments[0].scrollIntoView(true);", searchResult);
            String searchResultText = searchResult.getText();
            searchResultStringList.add(searchResultText);
        }
        return searchResultStringList;
    }
}
