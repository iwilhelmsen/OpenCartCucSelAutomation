package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

@CucumberOptions(
        features = "src/test/java/features/login",
        glue = "steps/loginSteps"
)

public class loginTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    public static String loginBrowser;

    @BeforeTest
    @Parameters({"suite-browser"})
    public void setBrowser(String browser){
        loginBrowser = browser;
    }
}