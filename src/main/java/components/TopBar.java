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
    public static WebDriverWait wait = new WebDriverWait(getDriver(), 25);

//    public TopBar(WebDriver driver){
//        webDriver = driver;
//        wait = new WebDriverWait(driver, 15);
//
//    }

    @FindBy(xpath = "//div[@class='language-selector-wrapper']")
    private WebElement languageButton;

    @FindBy(xpath = "//div[@class='user-info']")
    private WebElement singInButton;

    @FindBy(xpath = "//div[@class='header']")
    private WebElement cardButton;

    @FindBy(xpath = "//div[@class='language-selector-wrapper']//li")
    private By languagesList;

    public TopBar(){ PageFactory.initElements(getDriver(), this);
    }


    public TopBar selectCategoryFromDropDown(TopBarEnums topBarItem){
        getDriver().switchTo().frame("framelive");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='language-selector-wrapper']")));
        switch(topBarItem){
            case LANGUAGES:
                languageButton.click();
                //actions.moveToElement(webDriver.findElement((By) languageButton)).build().perform();
                break;
            case SIGNIN:
                //actions.moveToElement(webDriver.findElement((By) singInButton)).build().perform();
                break;
            case CARD:
              //  actions.moveToElement(webDriver.findElement((By) cardButton)).build().perform();
                break;
        }
        return this;
    }

    public ArrayList getAllLanguagesFromDropdown() {
        ArrayList<String> allLanguages = new ArrayList<>();
        List<WebElement> languages = getDriver().findElements(By.xpath("//div[@class='language-selector-wrapper']//li"));
        for (WebElement li: languages) {
            String lang = li.findElement(By.xpath(".//a")).getText();
            allLanguages.add(lang);
        }
        return allLanguages;
    }


}
