import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
    private WebDriver webDriver;

    private WebElement profileNavigateItem;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements();
    }

    private void initElements() {
        profileNavigateItem = webDriver.findElement(By.id("profile-nav-item"));
    }

    public boolean assertHomePageIsLoaded() {
        /*Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/",
                "Home page URL is wrong.");
        Assert.assertEquals(webDriver.getTitle(),"(3) LinkedIn",
                "Home page title is wrong.");
        Assert.assertTrue(profileNavigateItem.isDisplayed(),"Profile navigate item is not displayed on Home page.");*/
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/feed/")
                && webDriver.getTitle().contains("LinkedIn")
                && profileNavigateItem.isDisplayed();
    }
}
