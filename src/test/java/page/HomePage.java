package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id='profile-nav-item']")
    private WebElement profileNavigateItem;

    @FindBy(xpath = "//input[contains(@aria-owns, 'results')]")
    private WebElement searchElement;

    @FindBy(xpath = "//*[@id='nav-settings__dropdown-trigger']/div/span[1]")
    private WebElement profileDropdown;

    @FindBy(xpath = "//*[contains(@id,'dropdown-options')]/li[2]/ul[1]/li[1]")
    private WebElement settings;

    public HomePage(WebDriver webDriver) {
        initialization(webDriver);
    }

    public boolean homePageIsLoaded() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/feed/")
                && webDriver.getTitle().contains("LinkedIn")
                && profileNavigateItem.isDisplayed();
    }

    public SearchPage setSearchTerm(String searchTerm) throws InterruptedException {
        searchElement.sendKeys(searchTerm);
        searchElement.sendKeys(Keys.RETURN);
        sleep(5000);
        return new SearchPage(webDriver);
    }

    public ForgotPasswordPage openSettings() {
        profileDropdown.click();
        settings.click();

        return new ForgotPasswordPage(webDriver);
    }
}