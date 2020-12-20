package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SingInPage;

import static org.junit.Assert.assertTrue;

public class SingInPageStepDefs {
    SingInPage singInPage = new SingInPage();

    @When("I fill in {string}, {string}, {string}, {string}, {string}")
    public void i_fill_in(String firstName, String lastName, String email, String password, String birthday) {
        singInPage.fillAllFields(firstName, lastName, email, password, birthday);
    }

    @Then("I see {string} and {string} near Card button")
    public void i_see_name(String firstName, String lastName){
        assertTrue(singInPage.checkIfCorrectNameAppeared(firstName, lastName));
    }

    @Then("I see Firstname input is highlighted with red")
    public void i_see_is_highlighted_with_red() {
        assertTrue(singInPage.checkFieldBorderColor());
    }

    @Then("I see {string} warning message")
    public void i_see_warning_message(String string) {
        assertTrue(singInPage.checkIfProperWarningMessageAppeared(string));
    }

}
