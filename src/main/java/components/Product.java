package components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Product {
    private static WebDriver webDriver;

    private WebElement productPicture;
    private String productName;
    private double productPrice;
    private String productPromoPrice;

    public Product(WebDriver driver){
        webDriver = driver;
    }

    public Product(WebElement productPicture, String productName, double productPrice, String productPromoPrice) {
        this.productPicture = productPicture;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productPromoPrice = productPromoPrice;
    }
    public List<Product> getAllItems(By boxContainer) {
        List<Product> products = new ArrayList<>();
        List<WebElement> boxElements = webDriver.findElements(boxContainer);
        for (WebElement boxElement : boxElements) {
            WebElement productPicture = boxElement.findElement(By.xpath(".//img"));
            String productName = boxElement.findElement(By.xpath(".//h3[@itemprop='name']")).getText();
            double productPrice = Double.parseDouble(boxElement.findElement(By.xpath(".//span[@class='price']")).getText().substring(1));
            if(boxElement.findElements(By.xpath(".//span[@class='regular-price']")).size()!=0){
                productPromoPrice = boxElement.findElement(By.xpath(".//span[@class='regular-price']")).getText();
            } else { productPromoPrice=null; }
            Product product = new Product(productPicture, productName, productPrice, productPromoPrice);
            products.add(product);
        }
        return products;
    }
}
