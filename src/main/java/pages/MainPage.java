package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.ScreenShotUtil.makeScreenshot;

@Getter
public class MainPage extends BasePage {

    @FindBy(xpath ="//*[@name='email']")
    private WebElement subscribeInput;

    @FindBy(xpath ="//*[@value='Subscribe']")
    private WebElement subscribeButton;

    @FindBy(xpath ="//p[@id='block-newsletter-label']")
    private WebElement subscribeTextBlock;

    @FindBy(id ="_desktop_cart")
    private WebElement mainPageCarousel;

    public MainPage(){
        PageFactory.initElements(getDriver(), this);

    }

    public boolean isEmailValid(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        System.out.println(js.executeScript("return arguments[0].checkValidity();", subscribeInput));
        return (Boolean)js.executeScript("return arguments[0].checkValidity();", subscribeInput);
    }

    public void openMainPage() {getDriver().get("https://demo.prestashop.com/");}
    public void fillInEmail(String email){
        getDriver().switchTo().frame("framelive");
        waitUntilVisible(mainPageCarousel, 20);
        moveTo(subscribeTextBlock);
        System.out.println("You're here");
        subscribeInput.sendKeys(email);
        makeScreenshot();
        subscribeButton.click();
        System.out.println("1");
    }
}
