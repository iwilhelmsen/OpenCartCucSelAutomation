package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Parameters;
import pages.registerPage;

public class RegisterSteps extends BaseStep {
    protected pages.registerPage registerPage;

    @Parameters({"suite-browser"})
    public RegisterSteps(String browser) {
        super(browser);
    }

    @Given("User navigates to Register Page")
    public void userNavigatesToRegisterPage() {
        this.registerPage = new registerPage(this.driver);
    }

    @When("User enters in {string} in first name input")
    public void userEntersInInFirstNameInput(String firstName) {
        this.registerPage.enterFirstName(firstName);
    }

    @And("User enters in {string} in last name input")
    public void userEntersInInLastNameInput(String lastName) {
        this.registerPage.enterLastName(lastName);
    }

    @And("User enters in {string} in email input")
    public void userEntersInInEmailInput(String email) {
        this.registerPage.enterEmail(email);
    }

    @And("User enters in {string} in telephone input")
    public void userEntersInInTelephoneInput(String telephoneNumber) {
        this.registerPage.enterTelephone(telephoneNumber);
    }

    @And("User enters in {string} in password input")
    public void userEntersInInPasswordInput(String password) {
        this.registerPage.enterPassword(password);
    }

    @And("User repeats their {string} in confirm password")
    public void userRepeatsTheirInConfirmPassword(String password) {
        this.registerPage.enterConfirmPassword(password);
    }

    @And("User selects {string} to subscribe to newsletter")
    public void userSelectsToSubscribeToNewsletter(String subscribe) {
        this.registerPage.selectNewsletterSubscribe(Boolean.parseBoolean(subscribe));
    }

    @And("User endorses the privacy policy")
    public void userEndorsesThePrivacyPolicy() {
        this.registerPage.selectPrivacyPolicyOptIn();
    }

    @And("User clicks the Continue button")
    public void userClicksTheContinueButton() {
        this.registerPage.selectSubmitButton();
    }

    @Then("User lands on the blank page")
    public void userLandsOnTheBlankPage() {
    }

    @Then("User is presented with an error")
    public void userIsPresentedWithAnError() {
    }


}
