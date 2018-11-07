package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.GMailService;

public class CheckpointPage extends BasePage {

    @FindBy(xpath = "//*[@id='resend-url']")
    private WebElement recend;

    @FindBy(xpath = "//*[@id='sendemail-form']/div[1]/a[1]")
    private WebElement tryAnotherEmail;

    public CheckpointPage(WebDriver webDriver) {
        initialization(webDriver);
    }

    public boolean checkpointPageIsLoaded() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/checkpoint/rp/request-password-reset-submit")
                && webDriver.getTitle().contains("изменения пароля. | LinkedIn")
                && tryAnotherEmail.isDisplayed();
    }

    public PasswordResetPage recendUrl() {
        GMailService gMailService = new GMailService();
        gMailService.connect();

        recend.click();

        String messageSubject = "данное сообщение содержит ссылку для изменения пароля\n";
        String messageTo = "gdd0070@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 60);
        System.out.println("Content: " + message);
        return new PasswordResetPage(webDriver);
    }
}