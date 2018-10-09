import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static java.lang.Thread.sleep;

public class BadCodeExample3 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World!!!");
        WebDriver webDriver = new FirefoxDriver(); //запуск браузера Mozilla Firefox

        //переход на сайт https://www.google.com.ua/
        webDriver.navigate().to("https://www.google.com.ua/");

        //создал переменную для поля поиска
        WebElement searchField = webDriver.findElement(By.xpath("//*[@id='lst-ib']"));
        //Ввод в поле слово "Selenium"
        searchField.sendKeys("Selenium");
        //нажать ENTER
        searchField.sendKeys(Keys.ENTER);

        //задержка 3 секунды
        sleep(3000);
        //создал переменную для результатов поиска
        List<WebElement> searchResults = webDriver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));

        //вывести количество результатов поиска
        System.out.println("Search results count: " + searchResults.size());
        //вывести результаты поиска
        for (int i = 0; i < searchResults.size(); i++) {
            int j = i+1;
            System.out.println("Search term " + j + ":\n" + searchResults.get(i).getText() + "\n");
        }
        //вывести информацию о том были ли найдены результаты поиска
        if (searchResults.size() > 0) {
            System.out.println("\nsearchTerm was found");
        }
        else {
            System.out.println("\nsearchTerm not found");
        }
    }
}