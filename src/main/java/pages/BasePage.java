package pages;

import components.TopBar;
import components.TopMenu;
import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public abstract class BasePage {
    public static WebDriver driver;
    public static void setDriver(WebDriver webDriver) {    driver = webDriver;    }

    private TopBar topBar;
    private TopMenu topMenu;
    public BasePage() {
        this.topBar = new TopBar();
        this.topMenu = new TopMenu();
    }
    public static WebDriver getDriver() {        return driver;    }
    public WebElement waitUntilVisible(WebElement element, int time) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.visibilityOf(element));
    }
    public WebElement waitUntilClickable(WebElement element, int time) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
    public void clickWithJs(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", webElement);
    }
    public WebElement find(By locator){
        return getDriver().findElement(locator);
    }
    public void moveTo(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public void checkIframe(){
        if(!driver.findElements(By.id("framelive")).isEmpty()){
            getDriver().switchTo().frame("framelive");
        } }
}
