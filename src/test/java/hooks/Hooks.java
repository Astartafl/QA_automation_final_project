package hooks;

import driverManager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.BasePage;
import java.io.File;
import java.io.IOException;

import static io.qameta.allure.Allure.addAttachment;

public class Hooks {

    @Before
    public void initDriver(){
        DriverManager.setUpDriver();
        System.out.println("DriverManager.setUpDriver();");
    }
    @After
    public void quiteBrowser(Scenario scenario){
        if(scenario.isFailed()){
            File screenshotAs = ((TakesScreenshot) BasePage.getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                addAttachment("Screenshot", FileUtils.openInputStream(screenshotAs));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        DriverManager.quiteDriver();
    }

}
