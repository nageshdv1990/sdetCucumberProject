package cucumberTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions"},
        tags = "@orangeHrmFeatures",
        strict = true,
        plugin = {"pretty","html:target/cucumber-reports/reports2.html"},
        monochrome = true
)

public class ActivitiesRunner_orangeHrm {
    //empty
}

