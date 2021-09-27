package pages;

import org.openqa.selenium.WebDriver;

public class basePage {
    protected final String baseURL = "https://opencart.abstracta.us/index.php";
    protected WebDriver driver;
    private final String urlScreen = "https:";
    private final String urlRoutePrefix = "?route=";

    public basePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This broiler plate function takes in the destination desired
     * and appends it to the baseurl before sending it to the web driver
     * @param reqURL String the route desired by the page
     *               EX "account/login"
     */
    public void navigateTo(String reqURL) {
        //set the base url as the default option to send to the driver
        String destURL = this.baseURL;

        //if the request url is just a route destination and not a full
        //web address then format it correctly.
        if (!reqURL.contains(this.urlScreen)){
            destURL = destURL + this.urlRoutePrefix + reqURL;
        }

        //send the driver to that fully formatted requested page
        this.driver.get(destURL);
    }
}
