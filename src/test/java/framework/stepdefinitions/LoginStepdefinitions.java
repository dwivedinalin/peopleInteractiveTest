package framework.stepdefinitions;

import framework.pageobjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginStepdefinitions {

    @Steps
    LoginPage loginPage;

    @Given("When an existing user opens the marathi shaadi.com")
    public void when_an_existing_user_opens_the_marathi_shaadi_com() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.open_Login_link();

    }

    @When("User enters email")
    public void user_enters_email() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.enter_email();
    }

    @When("User enters password")
    public void user_enters_password() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.enter_password();
        loginPage.select_profile();
    }

    @When("User clicks on next button")
    public void user_clicks_on_next_button() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.click_Next();
    }

    @Then("Verify community name and mother tongue is same {string}")
    public void verify_community_name_and_mother_tongue_is_same(String string) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.verify(string);
    }


}
