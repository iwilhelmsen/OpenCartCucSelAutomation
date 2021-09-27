package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Parameters;
import pages.loginPage;

public class LoginSteps extends BaseStep {

    protected pages.loginPage loginPage;

    @Parameters({"suite-browser"})
    public LoginSteps(String browser) {
        super(browser);
    }

    @Given("User navigates to Login page")
    public void userNavigatesToLoginPage() {
        this.loginPage = new loginPage(this.driver);
    }

    @When("User enters {string} in email input")
    public void userEntersInEmailInput(String email) {
        this.loginPage.enterLoginEmail(email);
    }

    @And("User enters {string} in password input")
    public void userEntersInPasswordInput(String password) {
        this.loginPage.enterPasswordInput(password);
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
}
