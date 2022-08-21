package ru.kirzhoy.lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AboutPage extends BasePage {


    public AboutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='https://youtu.be/iMGwxdSH79o']")
    private WebElement movieFromMonkeyToHomo;

    public void clickMovieFromMonkeyToHomo(){
        movieFromMonkeyToHomo.click();
    }

    public void switchOverMovieFromMonkeyToHomo(){
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.youtube.com/watch?v=iMGwxdSH79o");
    }

    public void checkMovieFromMonkeyToHomoStarts(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Эволюция от обезьяны к человеку']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//h1[.='Эволюция от обезьяны к человеку']")).isDisplayed());

    }
}
