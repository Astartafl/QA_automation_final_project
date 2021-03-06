package components;

import components.ENUMS.TopBarEnums;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

import static pages.BasePage.getDriver;

@Getter
public class TopBar {
    public static WebDriver webDriver;
    public static WebDriverWait wait;

    @FindBy(xpath = "//div[@class='language-selector-wrapper']")
    private WebElement languageButton;

    @FindBy(xpath = "//div[@class='user-info']")
    private WebElement singInButton;

    @FindBy(xpath = "//div[@class='header']")
    private WebElement cardButton;

    @FindBy(xpath = "//div[@class='language-selector-wrapper']//li")
    private By languagesList;

    public TopBar(WebDriver driver){
        webDriver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(getDriver(), this);
    }


    public TopBar selectCategoryFromDropDown(TopBarEnums topBarItem){
        webDriver.switchTo().frame("framelive");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='language-selector-wrapper']")));
        switch(topBarItem){
            case LANGUAGES:
                languageButton.click();
                break;
            case SIGNIN:
                singInButton.click();
                break;
            case CARD:
                cardButton.click();
                break;
        }
        return this;
    }

    public ArrayList<String> getAllLanguagesFromDropdown() {
        ArrayList<String> allLanguages = new ArrayList<>();
        List<WebElement> languages = webDriver.findElements(By.xpath("//div[@class='language-selector-wrapper']//li"));
        for (WebElement li: languages) {
            String lang = li.findElement(By.xpath(".//a")).getText();
            allLanguages.add(lang);
        }
        return allLanguages;
    }


}
