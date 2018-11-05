import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static java.lang.Thread.sleep;

public class BadCodeExample5 {
    public static void main(String[] args) throws InterruptedException {
        String searchTerm = "Jack";

        WebDriver webDriver = new FirefoxDriver(); //запуск браузера Mozilla Firefox

        //переход на сайт https://www.google.com.ua/
        webDriver.navigate().to("https://linkedin.com/");

        //создал переменную для поля поиска
        WebElement searchField = webDriver.findElement(By.xpath("//*[@id='lst-ib']"));
        //Ввод в поле слово "Selenium"
        searchField.sendKeys(searchTerm);
        //нажать ENTER
        searchField.sendKeys(Keys.ENTER);

        //задержка 3 секунды
        sleep(3000);
        //создал переменную для результатов поиска
        List<WebElement> searchResults = webDriver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));

        //вывести количество результатов поиска
        System.out.println("Search results count: " + searchResults.size());

        for (WebElement searchResult:
                searchResults) {
            String searchResultText = searchResult.getText();
            System.out.println(searchResult.getText());
            if (searchResultText.toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("\nsearchTerm " + searchTerm + " was found");
            }
            else {
                System.out.println("\nsearchTerm " + searchTerm + " not found");
            }
        }
    }
}
