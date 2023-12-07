package TestRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/Features",
        glue = "StepDefination",
        monochrome = true,
        plugin = {"pretty","html:target/cucumber-reports/reports1.html"}
)

public class TestRun {
}
