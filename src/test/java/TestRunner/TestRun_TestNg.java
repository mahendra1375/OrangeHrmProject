package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/java/Features",
        glue = "StepDefination",
        monochrome = true,
        plugin = {"pretty","html:target/cucumber-reports/reports1.html"}
)

public class TestRun_TestNg extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
