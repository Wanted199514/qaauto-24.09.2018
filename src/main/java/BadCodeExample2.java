import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BadCodeExample2 {
    public static void main(String[] args) {
        System.out.println("Hello World!!!");
        WebDriver webDriver = new FirefoxDriver(); //запуск браузера Mozilla Firefox

        //переход на сайт https://www.google.com.ua/
        webDriver.navigate().to("https://www.google.com.ua/");
        //ввод в поле поиска слово "Selenium" (без кавычек)
        webDriver.findElement(new By.ByXPath("//*[@id=\"lst-ib\"]")).sendKeys("Selenium");
        //нажать на кнопку "Поиск в Google"
        webDriver.findElement(new By.ByXPath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")).click();
    }
}
