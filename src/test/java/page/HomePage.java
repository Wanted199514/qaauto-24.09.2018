package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    @FindBy(xpath = "//*[@id='profile-nav-item']")
    private WebElement profileNavigateItem;

    @FindBy(xpath = "//input[contains(@aria-owns, 'results')]")
    private WebElement searchElement;

    /**
     * Initialization of page elements
     * @param webDriver
     */
    public HomePage(WebDriver webDriver) {
        initialization(webDriver);
        waitUntilElementIsClickable(searchElement);
    }

    /**
     * check if this page is loaded
     * @return
     */
    public boolean homePageIsLoaded() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/feed/")
                && webDriver.getTitle().contains("LinkedIn")
                && profileNavigateItem.isDisplayed();
    }

    /**
     * Enter the value in the search field and press "Enter"
     * @param searchTerm - name what we write in searchElement field
     * @return either SearchPage
     */
    public SearchPage setSearchTerm(String searchTerm) {
        searchElement.sendKeys(searchTerm);
        searchElement.sendKeys(Keys.RETURN);
        return new SearchPage(webDriver);
    }
}