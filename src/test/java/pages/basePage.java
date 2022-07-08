package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class basePage {
    protected final String baseURL = "https://demo.opencart.com/";
    protected final String adminURL = "https://demo.opencart.com/admin/";
    protected WebDriver driver;
    private final String urlScreen = "https:";
    private final String urlRoutePrefix = "index.php?route=";
    private final String adminOption = "admin";
    private final int BASE_PAGE_DRIVER_TIMEOUT = 15;
    private final String selectChildXPathStart = "//*[normalize-space() = '";
    private final String selectChildXPathEnd = "'";

    public basePage(String browser) {
        switch (browser) {
            case "chrome" -> this.setupChrome();
            case "firefox" -> this.setupFirefox();
            default -> this.setupEdge();
        }
        this.driver.manage().timeouts().pageLoadTimeout(BASE_PAGE_DRIVER_TIMEOUT, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(BASE_PAGE_DRIVER_TIMEOUT, TimeUnit.SECONDS);
    }

    private void setupChrome() {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities = this.setupHttpOkOpt(desiredCapabilities);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(desiredCapabilities);
        this.driver = new ChromeDriver(chromeOptions);
    }

    private void setupFirefox() {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
        desiredCapabilities = this.setupHttpOkOpt(desiredCapabilities);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.merge(desiredCapabilities);
        this.driver = new FirefoxDriver(firefoxOptions);
    }

    private void setupEdge() {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
        desiredCapabilities = this.setupHttpOkOpt(desiredCapabilities);
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.merge(desiredCapabilities);
        this.driver = new EdgeDriver(edgeOptions);
    }

    private DesiredCapabilities setupHttpOkOpt(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return desiredCapabilities;
    }

    /**
     * This broiler plate function takes in the destination desired
     * and appends it to the baseurl before sending it to the web driver
     *
     * @param reqURL String the route desired by the page
     *               EX "account/login"
     */
    public void navigateTo(String reqURL) {
        //set the base url as the default option to send to the driver
        String destURL = this.baseURL;

        if (reqURL.equals(this.adminOption)){
            destURL = this.adminURL;
        }else {
            //if the request url is just a route destination and not a full
            //web address then format it correctly.
            if (!reqURL.contains(this.urlScreen)) {
                destURL = destURL + this.urlRoutePrefix + reqURL;
            }
        }


        //send the driver to that fully formatted requested page
        this.driver.get(destURL);
    }

    /**
     * This method is a base finder method that returns a web element by a by
     * @param locator By
     * @return WebElement
     */
    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /**
     * Base method for clicking based on a By
     * @param locator By
     */
    public void click(By locator) {
        find(locator).click();
    }

    /**
     * Base method for typing text into a web element
     * @param inputText String
     * @param locator By
     */
    public void type(String inputText, By locator) {
        find(locator).sendKeys(inputText);
    }

    /**
     * This method selects an option from a list of options in a select web element
     * @param option String
     * @param locator By
     */
    ////*[@id="input-customer-group"]//*[text()='Default']
    public void clickAndSelectOpt(String option, By locator){
        try {
            this.click(locator);
            WebElement desiredSelection = locator.findElement((SearchContext) By.xpath("//*[normalize-space() = '" + option +"'"));
            this.click((By) locator.findElement((SearchContext) By.xpath(this.createXPathSelectOptionString(option))));
        }catch (org.openqa.selenium.NoSuchElementException exception){
            //@TODO stub for logging
        }
    }

    private String createXPathSelectOptionString(String option){
        return this.selectChildXPathStart + option + this.selectChildXPathEnd;
    }

    /**
     * Base method to detect if a web element is displayed for the user to see.
     * @param locator By
     * @return Boolean
     */
    public Boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException exception) {
            return false;
            //@TODO stub for logging
        }
    }

    /**
     * Base method to detect if a web element is displayed for the user to see
     * but also includes a timeout parameter to stop the search.
     * @param locator By
     * @param timeout Integer
     * @return Boolean
     */
    public Boolean isDisplayed(By locator, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout).getSeconds());
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
        return true;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
