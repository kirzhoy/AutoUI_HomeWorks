package ru.kirzhoy.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BasePage {
    @FindBy(xpath = "//div[@id='top_menu']//a[.='О проекте']")
    private WebElement buttonAbout;

    @FindBy(xpath = "//a[@href='search/']")
    private WebElement buttonSearch;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickAboutButton(){
        buttonAbout.click();
    }

    public void clickToButtonSearch(){
        buttonSearch.click();
      }

}
