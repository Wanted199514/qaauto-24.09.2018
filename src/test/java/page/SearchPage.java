package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SearchPage extends BasePage {
    private WebDriver webDriver;

    @FindBy(xpath = "//*[@class='ember-view']/header/div/div")
    private WebElement filtersSearch;

    @FindBy(xpath = "//li[contains(@class, 'search-result__occluded-item')]")
    private List<WebElement> searchResults;

    public SearchPage(WebDriver webDriver) {
        initialization(webDriver);
    }

    public boolean searchPageIsLoaded() {
        return webDriver.getCurrentUrl().contains("https://www.linkedin.com/search/results/all/?keywords=")
                && webDriver.getTitle().contains(" | Поиск | LinkedIn")
                && filtersSearch.isDisplayed();
    }

    public int searchResultsIsLoaded() {
        return searchResults.size();
    }

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