package pages;

import lombok.Getter;
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
        System.out.println(getDriver());
    }

    public void openMainPage() {getDriver().get("https://demo.prestashop.com/");}
    public void fillInEmail(String email){
        getDriver().switchTo().frame("framelive");
        //subscribeButton.click();
        System.out.println(subscribeInput);
        System.out.println(subscribeButton);
        System.out.println(mainPageCarousel);
        waitUntilVisible(mainPageCarousel, 20);
        moveTo(subscribeTextBlock);
        waitUntilVisible(subscribeButton, 20);
        System.out.println("You're here");
        //subscribeButton.click();
  //
        subscribeInput.sendKeys(email);
        makeScreenshot();
        subscribeButton.click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().getText();

    }
}
