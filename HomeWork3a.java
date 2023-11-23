package ru.kirzhoy.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class HomeWork3a {
    public static void main(String[] args) throws InterruptedException {
        // Выдача поискового запроса со страницы поиска, открытой через главное меню

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://antropogenez.ru/");
        driver.findElement(By.xpath("//a[@href='search/']")).click();
        String searchQuery = "австралопитек" + " " + new Random().nextInt(500);
        driver.findElement(By.id("gsc-i-id1")).sendKeys(searchQuery);
        driver.findElement(By.xpath("//div [@id='___gcse_0']//button[@class='gsc-search-button gsc-search-button-v2']")).click();

        Thread.sleep(5000);
        driver.quit();

    }
}

