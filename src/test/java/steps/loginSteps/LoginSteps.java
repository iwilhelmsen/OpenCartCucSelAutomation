package steps.loginSteps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;
import runners.loginTestRunner;

public class LoginSteps{

    private pages.loginPage loginPage;

    @Given("User navigates to Login page")
    public void userNavigatesToLoginPage() {
        this.loginPage = new loginPage(loginTestRunner.loginBrowser);
    }

    @When("User enters {string} in email input")
    public void userEntersInEmailInput(String string) {
        this.loginPage.enterLoginEmail(string);
    }

    @And("User enters {string} in password input")
    public void userEntersInPasswordInput(String string) {
        this.loginPage.enterPasswordInput(string);
    }

    @And("User clicks Login")
    public void userClicksLogin() {
        this.loginPage.clickLogin();
    }

    @Then("the user is logged in")
    public void theUserIsLoggedIn() {
    }

    @Then("the user is not logged in")
    public void theUserIsNotLoggedIn() {
    }

    @After
    public void tearDown(){
        this.loginPage.getDriver().close();
    }
}
