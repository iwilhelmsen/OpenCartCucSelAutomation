package steps.registerSteps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.registerPage;
import runners.registerTestRunner;

public class RegisterSteps{
    protected pages.registerPage registerPage;

    @Given("User navigates to Register Page")
    public void userNavigatesToRegisterPage() {
        this.registerPage = new registerPage(registerTestRunner.registerBrowser);
    }

    @When("User enters in {string} in first name input")
    public void userEntersInInFirstNameInput(String string) {
        this.registerPage.enterFirstName(string);
    }

    @And("User enters in {string} in last name input")
    public void userEntersInInLastNameInput(String string) {
        this.registerPage.enterLastName(string);
    }

    @And("User enters in {string} in email input")
    public void userEntersInInEmailInput(String string) {
        this.registerPage.enterEmail(string);
    }

    @And("User enters in {string} in telephone input")
    public void userEntersInInTelephoneInput(String string) {
        this.registerPage.enterTelephone(string);
    }

    @And("User enters in {string} in password input")
    public void userEntersInInPasswordInput(String string) {
        this.registerPage.enterPassword(string);
    }

    @And("User repeats their {string} in confirm password")
    public void userRepeatsTheirInConfirmPassword(String string) {
        this.registerPage.enterConfirmPassword(string);
    }

    @And("User selects {string} to subscribe to newsletter")
    public void userSelectsToSubscribeToNewsletter(String string) {
        this.registerPage.selectNewsletterSubscribe(Boolean.parseBoolean(string));
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
        Assert.assertTrue(this.registerPage.failIconAppeared(), "This step failed when it should have passed.");
    }

    @After
    public void tearDown(){
        this.registerPage.getDriver().close();
    }
}
