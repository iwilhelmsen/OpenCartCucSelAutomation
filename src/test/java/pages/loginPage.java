package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage extends basePage {
    private final String pageURL = "account/login";
    private final By loginEmailInput = By.xpath("//input[@placeholder='E-Mail Address']");
    private final By loginPasswordInput = By.xpath("//input[@placeholder='Password']");
    private final By loginLoginButton = By.xpath("//input[@value='Login']");

    public loginPage(String browser){
        super(browser);
        this.navigateTo(this.pageURL);
    }

    /**
     * This method enters a string into the login page's email input
     *
     * @param email String the desired string to be entered.
     */
    public void enterLoginEmail(String email) {
        this.type(email, this.loginEmailInput);
    }

    /**
     * This method enters a string into the login page's password input
     *
     * @param password String the desired string to be entered
     */
    public void enterPasswordInput(String password) {
        this.type(password, this.loginPasswordInput);
    }

    /**
     * This method clicks on the login button on the login page.
     */
    public void clickLogin() {
        this.click(this.loginLoginButton);
    }

    public String getPageURL() {
        return pageURL;
    }
}
