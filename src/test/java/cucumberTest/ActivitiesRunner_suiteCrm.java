package cucumberTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions"},
        tags = "@suiteCrm",
        strict = true,
        plugin = {"pretty","html:target/cucumber-reports/reports3.html"},
        monochrome = true
)

public class ActivitiesRunner_suiteCrm {
    //empty
}

