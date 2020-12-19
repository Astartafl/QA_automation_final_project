package components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Product {
    private WebDriver driver;

    private String productName;
    private double productPrice;
    private String productPromoPrice;

    public Product(WebDriver driver){
        this.driver = driver;
    }

    public Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
      //  this.productPromoPrice = productPromoPrice;
    }
    public List<Product> getAllItems(By boxContainer) {
        List<Product> products = new ArrayList<>();
        List<WebElement> boxElements = driver.findElements(boxContainer);
        for (WebElement boxElement : boxElements) {
            String productName = boxElement.findElement(By.xpath(".//h3[@itemprop='name']")).getText();
            Double productPrice = Double.parseDouble(boxElement.findElement(By.xpath(".//span[@class='price']")).getText().substring(1));
            //String productPromoPrice = boxElement.findElement(By.xpath(".//span[@class='regular-price']")).getText();
            //add all elements of product

            Product product = new Product(productName, productPrice);
            products.add(product);
        }
        return products;
    }
}
