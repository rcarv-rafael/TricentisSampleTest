package tricentisample;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-report.html"},
        glue = "StepDefinitions",
        features = "src/test/resources/features",
                publish = true
)
public class RunCucumberTest {
}
