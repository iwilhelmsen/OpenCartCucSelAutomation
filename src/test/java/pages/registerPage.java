package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registerPage extends basePage {
    private final String pageURL = "account/register";
    private final By registerFirstNameInput = By.xpath("//input[@placeholder='First Name']");
    private final By registerLastNameInput = By.xpath("//input[@placeholder='Last Name']");
    private final By registerEmailInput = By.xpath("//input[@placeholder='E-Mail']");
    private final By registerTelephoneInput = By.xpath("//input[@placeholder='Telephone']");
    private final By registerPasswordInput = By.xpath("//input[@placeholder='Password']");
    private final By registerConfirmPasswordInput = By.xpath("//input[@placeholder='Password Confirm']");
    private final By registerNewsletterOptInSelect = By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input");
    private final By registerNewsletterOptOutSelect = By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input");
    private final By registerPrivacyPolicyCheckBox = By.xpath("//input[@name='agree']");
    private final By registerSubmitButton = By.xpath("//input[@value='Continue']");

    public registerPage(WebDriver driver){
        super(driver);
        this.navigateTo(this.pageURL);
    }

    /**
     * This method enters the first name into the first name input
     * inside the register form
     * @param firstName String
     */
    public void enterFirstName(String firstName){
        this.driver.findElement(this.registerFirstNameInput).sendKeys(firstName);
    }

    /**
     * This method enters the last name into the last name input
     * inside the register form
     * @param lastName String
     */
    public void enterLastName(String lastName){
        this.driver.findElement(this.registerLastNameInput).sendKeys(lastName);
    }

    /**
     * This method enters the email into the email input inside the
     * register form
     * @param email String
     */
    public void enterEmail(String email){
        this.driver.findElement(this.registerEmailInput).sendKeys(email);
    }

    /**
     * This method enters the telephone number into the telephone number input
     * inside the register form.
     * @param telephoneNumber String
     */
    public void enterTelephone(String telephoneNumber){
        this.driver.findElement(this.registerTelephoneInput).sendKeys(telephoneNumber);
    }

    /**
     * This method enters the password into the password input inside
     * the register form.
     * @param password String
     */
    public void enterPassword(String password){
        this.driver.findElement(this.registerPasswordInput).sendKeys(password);
    }

    /**
     * This method enters the password into the confirm password input
     * inside the register form.
     * @param password String
     */
    public void enterConfirmPassword(String password){
        this.driver.findElement(this.registerConfirmPasswordInput).sendKeys(password);
    }

    /**
     * This method enters the user choice to subscribe or not to the site
     * newsletter
     * @param flag Boolean TRUE indicates subscribing: FALSE indicates
     *             note subscribing
     */
    public void selectNewsletterSubscribe(Boolean flag){
        if (flag){
            this.driver.findElement(this.registerNewsletterOptInSelect).click();
        }
        else {
            this.driver.findElement(this.registerNewsletterOptOutSelect).click();
        }
    }

    /**
     * This method enters the user choice to opt in (or not) to the site
     * privacy policy.
     */
    public void selectPrivacyPolicyOptIn () {
        this.driver.findElement(this.registerPrivacyPolicyCheckBox).click();
    }

    /**
     * This method submits the form for verification.
     */
    public void selectSubmitButton(){
        this.driver.findElement(this.registerSubmitButton).click();
    }
}
