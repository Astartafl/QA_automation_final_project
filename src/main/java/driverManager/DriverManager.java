package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jsoup.Connection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;

public class DriverManager {

    public static synchronized void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        BasePage.setDriverThreadLocal(driver);
    }

    public static void quiteDriver() {
        if(BasePage.getDriverThreadLocal()!=null){
            BasePage.getDriver().quit();
            BasePage.getDriverThreadLocal().remove();
        }


    }

}
