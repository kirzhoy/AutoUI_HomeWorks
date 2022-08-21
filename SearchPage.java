package ru.kirzhoy.lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gsc-i-id1")
    private WebElement searchBar;

    @FindBy(xpath = "//div[@id='___gcse_0']//button[@class='gsc-search-button gsc-search-button-v2']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//div[contains(text(),'Найдено результатов')]")
    private WebElement titleResultsFound;

    public void findBySearchBar(String searchQuery){
        searchBar.sendKeys(searchQuery);
        buttonSearch.click();
    }

    public void checkTitleResultsFound(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Найдено результатов')]")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Найдено результатов')]")).isDisplayed());
    }

}
