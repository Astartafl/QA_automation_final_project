package stepDefs;

import components.ENUMS.TopBarEnums;
import components.ENUMS.TopMenuEnum;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.MainPage;
import static org.junit.Assert.*;

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

    @When("I click on {}")
    public void i_click_on(TopBarEnums topBarItem) {
        mainPage.getTopBar().selectCategoryFromDropDown(topBarItem);
    }



    @When("I hover mouse over {} and see {string} and {string} submenu")
    public void i_hover_mouse_over_menu(TopMenuEnum item, String firstSub, String secondSub) {
        assertTrue(mainPage.getTopMenu().checkForCategories(item, firstSub, secondSub));
    }

    @When("I also hover over {} see no subcategories appears")
    public void i_hover_mouse_over_art(TopMenuEnum item) {
        assertTrue(mainPage.getTopMenu().checkForNoCategories(item));
    }

    @Then("I see {string} products")
    public void iSeeProducts(String arg0) {
        assert((mainPage.getAllProducts().size().));;
        assertTrue(mainPage.checkAllPricesArePositive());

    }
}
