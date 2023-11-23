package ru.kirzhoy.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class PageObjectTest {
    WebDriver driver;

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver(){
        driver = new ChromeDriver();
        driver.get("https://antropogenez.ru/");
    }

    @Test 
    @DisplayName("Просмотр записи лекции при переходе со страницы _О проекте_ на сторонний портал (YouTube)")
    void youTubeFromPageAboutProjectTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAboutButton();
        AboutPage aboutPage = new AboutPage(driver);
        aboutPage.clickMovieFromMonkeyToHomo();
        aboutPage.switchOverMovieFromMonkeyToHomo();
        aboutPage.checkMovieFromMonkeyToHomoStarts();
    }

    @Test
    @DisplayName("Выдача поискового запроса со страницы поиска, открытой через главное меню")
    void requestOnSearchPageFromMainMenuTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickToButtonSearch();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.findBySearchBar("австралопитек" + " " + new Random().nextInt(500));
        searchPage.checkTitleResultsFound();

    }
    @AfterEach
    void quitDriver(){
        driver.quit();
    }

}
