package ru.kirzhoy.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork3a {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://antropogenez.ru/");
        driver.findElement(By.xpath("//a[@href='search/']")).click();
        driver.findElement(By.id("gsc-i-id1")).sendKeys("австралопитек");
        driver.findElement(By.xpath("//div [@id='___gcse_0']//button[@class='gsc-search-button gsc-search-button-v2']")).click();

        Thread.sleep(5000);
        driver.quit();




    }
}

        /*driver.get("https://antropogenez.ru/");
        WebElement topAbout = driver.findElement(By.xpath("//div[@id='top_menu']//a[.='О проекте'] "));
        topAbout.click();
        WebElement movie = driver.findElement(By.xpath("//a[@href='https://youtu.be/iMGwxdSH79o']"));
        movie.click();*/

//следующий сценарий: с главной перейти на поиск, вбить "австралопитек". Тест-кейсы писать?
/*
        Thread.sleep(5000);
        driver.quit();*/
