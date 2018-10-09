import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BadCodeExample {
    public static void main(String[] args) {
        System.out.println("Hello World!!!");
        WebDriver webDriver = new FirefoxDriver(); //запуск браузера Mozilla Firefox

        //переход на сайт https://www.google.com.ua/
        webDriver.navigate().to("https://www.google.com.ua/");
        //ввод в поле поиска слово "Selenium" (без кавычек) и нажать кнопку Enter
        webDriver.findElement(new By.ByXPath("//*[@id=\"lst-ib\"]")).sendKeys("Selenium", Keys.ENTER);
    }
}