package ru.kirzhoy.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork3 {
    public static void main(String[] args) throws InterruptedException {
        //Просмотр записи лекции при переходе со страницы "О проекте" на сторонний портал (YouTube)

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://antropogenez.ru/");
        WebElement topAbout = driver.findElement(By.xpath("//div[@id='top_menu']//a[.='О проекте'] "));
        topAbout.click();
        WebElement movie = driver.findElement(By.xpath("//a[@href='https://youtu.be/iMGwxdSH79o']"));
        movie.click();

        Thread.sleep(5000);
        driver.quit();

    }

}
