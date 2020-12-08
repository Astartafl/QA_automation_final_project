package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MainPage;

import static org.junit.Assert.assertFalse;

public class MainPageStepdefs {

    MainPage mainPage = new MainPage();

    @Given("I am on MainPage")
    public void iAmOnMainPage() {
        mainPage.openMainPage();
    }

    @When("I enter {string} email")
    public void iEnterTttEmail(String email) {
        mainPage.fillInEmail(email);
    }

    @Then("I see error message")
    public void iSeeStringMessage() {
        assertFalse(mainPage.isEmailValid());
    }
}
