package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/java/features/register",
        glue = "steps/registerSteps"
)
public class registerTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    public static String registerBrowser;

    @BeforeSuite
    @Parameters({"suite-browser"})
    public void setBrowser(String browser){
        registerBrowser = browser;
    }
}
