package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = "src/main/resources/features", glue = {"StepDefinitions"}, monochrome = true,
        plugin = {
                "pretty",
                "json:target/jsonreports/report.json",
                "junit:target/junitreports/report.xml",
                "html:target/htmlreports/report.html"}

        //tags = "@SmokeTesting or @Google"

)

public class TestRunner {

}
