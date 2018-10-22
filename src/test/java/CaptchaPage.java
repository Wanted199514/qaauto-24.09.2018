import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CaptchaPage {
    private WebDriver webDriver;

    private WebElement captchaPageisLoaded;

    public CaptchaPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements();
    }

    private void initElements() {
        captchaPageisLoaded = webDriver.findElement(By.id("recaptcha-accessible-status"));
    }

    public boolean captchaPageIsLoaded() {
        return webDriver.getCurrentUrl().contains("https://www.linkedin.com/uas/consumer-captcha-v2?challengeId=")
                && webDriver.getTitle().equals("Проверка безопасности | LinkedIn")
                && captchaPageisLoaded.isDisplayed();
    }
}
