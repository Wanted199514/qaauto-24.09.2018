import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public boolean homePageIsLoaded() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/feed/")
                && webDriver.getTitle().equals("(3) LinkedIn")
                && profileNavigateItem.isDisplayed();
    }
}
