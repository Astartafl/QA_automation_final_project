package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jsoup.Connection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import pages.BasePage;

public class DriverManager {

    public static synchronized void setUpDriver() {
        WebDriver driver;
        String browserType = System.getProperty("browser");
        if (browserType == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            switch (browserType) {
                case "Chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    System.out.println("Open Chrome");
                    break;
                case "Firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    System.out.println("Open Firefox");
                    break;
                case "Opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    System.out.println("Open Opera");
                    break;
                default:
                    throw new RuntimeException();
            }
        }
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
