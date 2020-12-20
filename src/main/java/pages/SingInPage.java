package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class SingInPage extends BasePage {

    @FindBy(xpath = "//div[@class='no-account']//a[text()[contains(.,'No account?')]]")
    private WebElement linkToSingInPage;

    @FindBy(xpath = "//span[@class='custom-radio']//input[@value='2']")
    private WebElement genderRadioButton;

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='email' and @class='form-control']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passWordInput;

    @FindBy(xpath = "//input[@name='birthday']")
    private WebElement birthDayInput;

    @FindBy(xpath = "//input[@name='customer_privacy']")
    private WebElement customerPrivacyButton;

    @FindBy(xpath = "//input[@name='psgdpr']")
    private WebElement termsAndConditionsButton;

    @FindBy(xpath = "//button[text()[contains(.,'Save')]]")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@id='_desktop_user_info']//span[@class='hidden-sm-down']")
    private WebElement nameNearCardButton;

    public SingInPage(){ PageFactory.initElements(getDriver(), this); }

    public void fillAllFields(String firstName, String lastName, String email, String password, String birthday){
        checkIframe();
        waitUntilClickable(linkToSingInPage, 60);
        linkToSingInPage.click();
        waitUntilClickable(firstNameInput, 60);
        genderRadioButton.click();
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passWordInput.sendKeys(password);
        birthDayInput.sendKeys(birthday);
        moveTo(saveButton);
        customerPrivacyButton.click();
        termsAndConditionsButton.click();
        saveButton.submit();
        saveButton.click();
    }

    public boolean checkIfCorrectNameAppeared(String firstName, String lastName){
        String fullName = firstName + ' ' + lastName;
        return (nameNearCardButton.getText()).equals(fullName);
    }

    public boolean checkFieldBorderColor(){
        return firstNameInput.getCssValue("outline").contains("rgb(255, 76, 76)");
    }

    public boolean checkIfProperWarningMessageAppeared(String warning){
        return getDriver().findElement(By.xpath(".//li[@class='alert alert-danger']")).getText().equals(warning);
    }

}
