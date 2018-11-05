import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckpointPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id='resend-url']")
    private WebElement recend;

    @FindBy(xpath = "//*[@id='sendemail-form']/div[1]/a[1]")
    private WebElement tryAnotherEmail;

    public CheckpointPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public boolean checkpointPageIsLoaded() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/checkpoint/rp/request-password-reset-submit")
                && webDriver.getTitle().contains("изменения пароля. | LinkedIn")
                && tryAnotherEmail.isDisplayed();
    }

    public void recendUrl() {
        recend.click();
    }
}
