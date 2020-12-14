package stepDefs;

import components.ENUMS.TopBarEnums;
import components.ENUMS.TopMenuEnum;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import pages.MainPage;

import java.util.List;

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

    @Then("I see {int} languages")
    public void i_see_languages(int num) {
        Assert.assertEquals(num, mainPage.getTopBar().getAllLanguagesFromDropdown().size());
    }
    @Then("I see {string} language")
    public void i_see_language(String language) {
        assertTrue(mainPage.getTopBar().getAllLanguagesFromDropdown().contains(language));
    }

    @When("I hover mouse over {} and see subcategories submenu")
    public void i_hover_mouse_over_menu(TopMenuEnum item, DataTable dataTable) {
        List<String> strings = dataTable.asList();
        assertTrue(mainPage.getTopMenu().checkForCategories(item, strings));
    }

    @When("I also hover over {} see no subcategories appears")
    public void i_hover_mouse_over_art(TopMenuEnum item) {
        assertTrue(mainPage.getTopMenu().checkForNoCategories(item));
    }

    @Then("I see {int} products")
    public void iSeeProducts(int arg0) {
        Assertions.assertThat(mainPage.getAllProducts().size()).isEqualTo(arg0);
        assertTrue(mainPage.checkAllPricesArePositive());

    }

}
