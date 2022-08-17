package ru.kirzhoy.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class HomeWork5Test {
    WebDriver driver;
    WebDriverWait webDriverWait;

   private final static String ANTROPOGENEZ_BASE_URL = "https://antropogenez.ru/";

   @BeforeAll
   static void registerDriver(){
       WebDriverManager.chromedriver().setup();
   }

   @BeforeEach
   void setupBrowser(){
       driver = new ChromeDriver();
       webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
       Actions actions = new Actions(driver);
       driver.get(ANTROPOGENEZ_BASE_URL);
   }

   @Test
   @DisplayName("Просмотр записи лекции при переходе со страницы _О проекте_ на сторонний портал (YouTube)")
    void youTubeFromPageAboutProjectTest() throws InterruptedException {
       WebElement topAbout = driver.findElement(By.xpath("//div[@id='top_menu']//a[.='О проекте'] "));
       topAbout.click();
       WebElement movie = driver.findElement(By.xpath("//a[@href='https://youtu.be/iMGwxdSH79o']"));
       movie.click();
       driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.youtube.com/watch?v=iMGwxdSH79o");
       webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Эволюция от обезьяны к человеку']")));
       Assertions.assertTrue(driver.findElement(By.xpath("//h1[.='Эволюция от обезьяны к человеку']")).isDisplayed());


   }

   @Test
   @DisplayName("Выдача поискового запроса со страницы поиска, открытой через главное меню")
   void requestOnSearchPageFromMainMenuTest() throws InterruptedException {
       driver.findElement(By.xpath("//a[@href='search/']")).click();
       String searchQuery = "австралопитек" + " " + new Random().nextInt(500);
       driver.findElement(By.id("gsc-i-id1")).sendKeys(searchQuery);
       driver.
         findElement
                (By.xpath("//div[@id='___gcse_0']//button[@class='gsc-search-button gsc-search-button-v2']")).click();
       webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Найдено результатов')]")));
       Assertions.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Найдено результатов')]")).isDisplayed());
      }

   @AfterEach
    void quitBrowser(){
       driver.quit();
   }
 }

