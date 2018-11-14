package page;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckpointPage extends BasePage {

    @FindBy(xpath = "//*[@id='resend-url']")
    private WebElement resend;

    @FindBy(xpath = "//*[@id='sendemail-form']/div[1]/a[1]")
    private WebElement tryAnotherEmail;

    /**
     * initialization of page elements
     * @param webDriver
     */
    public CheckpointPage(WebDriver webDriver) {
        initialization(webDriver);
    }

    /**
     * check if this page is loaded
     * @return
     */
    public boolean checkpointPageIsLoaded() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/checkpoint/rp/request-password-reset-submit")
                && webDriver.getTitle().contains("изменения пароля. | LinkedIn")
                && tryAnotherEmail.isDisplayed();
    }

    /**
     * send link to mail
     */
    public void resendUrl() {
        gMailService.connect();

        resend.click();
    }

    /**
     * pick up a link from the mail and open this link on the page
     * @return
     */
    public PasswordResetPage openURL() {
        String messageSubject = "данное сообщение содержит ссылку для изменения пароля";
        String messageTo = "test199514@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 60);
        System.out.println("Content: " + message);

        String findMessage = StringUtils.substringBetween(message,"нажмите <a href=\"","\" style").replace("amp;","");
        System.out.println(findMessage);
        webDriver.get(findMessage);
        return new PasswordResetPage(webDriver);
    }
}