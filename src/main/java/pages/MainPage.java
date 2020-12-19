package pages;

import components.Product;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

import static utils.ScreenShotUtil.makeScreenshot;
@Slf4j
@Getter
public class MainPage extends BasePage {

    private Product product;
    private By productsList = By.xpath("//div[@class='products row']//div[@itemprop='itemListElement']");

    @FindBy(xpath ="//*[@name='email']")
    private WebElement subscribeInput;

    @FindBy(xpath ="//*[@value='Subscribe']")
    private WebElement subscribeButton;

    @FindBy(xpath ="//p[@id='block-newsletter-label']")
    private WebElement subscribeTextBlock;

    @FindBy(xpath ="//ul[@class='carousel-inner']")
    private WebElement mainPageCarousel;

    @FindBy(id ="framelive")
    private WebElement iframelive;

    public MainPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public boolean isEmailValid(){
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        return (Boolean)js.executeScript("return arguments[0].checkValidity();", subscribeInput);
    }

    public void openMainPage() {getDriver().get("https://demo.prestashop.com/"); }
    public void fillInEmail(String email){
        getDriver().switchTo().frame("framelive");
        System.out.println(mainPageCarousel);
        System.out.println("before carousel");
        waitUntilVisible(mainPageCarousel, 60);
        System.out.println("after carousel");
        moveTo(subscribeTextBlock);
        System.out.println("You're here");
        subscribeInput.sendKeys(email);
        makeScreenshot();
        subscribeButton.click();
    }
    public List<Product> getAllProducts() {
        checkIframe();

        waitUntilVisible(mainPageCarousel, 60);
        Product product = new Product(getDriver());
        return product.getAllItems(productsList);
    }

    public boolean checkAllPricesArePositive(){
        log.info("checkAllPricesArePositive");
        List<Product> array = getAllProducts();  //rename array!
        List<Product> notPositivePriseProducts = new ArrayList<>();
        for (Product li : array){
            if(li.getProductPrice()<=0){
                notPositivePriseProducts.add(li);
            }
        }
        return notPositivePriseProducts.size()==0;
    }
}
