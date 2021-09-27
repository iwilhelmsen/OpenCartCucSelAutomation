package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

public class BaseStep {
    protected WebDriver driver;

    public BaseStep(String browser) {
        switch (browser){
            case "chrome" :
                this.driver = new ChromeDriver();
                break;
            case "firefox" :
                this.driver = new FirefoxDriver();
                break;
            default:
                this.driver = new EdgeDriver();
                break;
        }
    }
}
