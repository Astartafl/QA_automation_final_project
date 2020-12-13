package components;

import components.ENUMS.TopMenuEnum;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;
import static pages.BasePage.getDriver;

@Getter
public class TopMenu {
    public static WebDriver webDriver;
    public static WebDriverWait wait = new WebDriverWait(getDriver(), 25);

    @FindBy(xpath = "//li[@id='category-3']")
    private WebElement clothesTopMenu;

    @FindBy(xpath = "//li[@id='category-6']")
    private WebElement accessoriesTopMenu;

    @FindBy(xpath = "//li[@id='category-9']")
    private WebElement artTopMenu;

    public TopMenu() {
        PageFactory.initElements(getDriver(), this);
    }

    public void checkIframe(){
        if(!getDriver().findElements(By.id("framelive")).isEmpty()){
            getDriver().switchTo().frame("framelive");
        } }
    public ArrayList<String> selectCategoryFromDropDown(TopMenuEnum topMenuItem) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='category-3']")));
        ArrayList<String> allSubCategories = new ArrayList<>();
        Actions actions = new Actions(getDriver());
        switch (topMenuItem) {
            case CLOTHES:
                actions.moveToElement(getDriver().findElement(By.xpath("//li[@id='category-3']"))).build().perform();
                allSubCategories = getSubCategories("//li[@id='category-3']//li");
                break;
            case ACCESSORIES:
                actions.moveToElement(getDriver().findElement(By.xpath("//li[@id='category-6']"))).build().perform();
                allSubCategories = getSubCategories("//li[@id='category-6']//li");
                break;
            case ART:
                actions.moveToElement(getDriver().findElement(By.xpath("//li[@id='category-9']"))).build().perform();
                allSubCategories = getSubCategories("//li[@id='category-9']//li");
                break;
        }
        return allSubCategories;
    }

    public ArrayList<String> getSubCategories(String elemXpath) {
        ArrayList<String> allSubCategories = new ArrayList<>();
        List<WebElement> subcategories = getDriver().findElements(By.xpath(elemXpath));
        for (WebElement li : subcategories) {
            String sub = li.findElement(By.xpath(".//a")).getText();
            allSubCategories.add(sub);
        }
        return allSubCategories;
    }

    public boolean checkForCategories(TopMenuEnum enumItem, String firstSub, String secondSub){
        checkIframe();
        return selectCategoryFromDropDown(enumItem).containsAll(Arrays.asList(firstSub,secondSub));
    }
    public boolean checkForNoCategories(TopMenuEnum enumItem){
        checkIframe();
        return selectCategoryFromDropDown(enumItem).size() == 0;
    }
}