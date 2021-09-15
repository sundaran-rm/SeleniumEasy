package StepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class AmazonSteps {
    WebDriver driver =null;
    private CommonSteps commonSteps;

    public AmazonSteps (CommonSteps commonSteps) {
        this.commonSteps = commonSteps;
        driver = commonSteps.getDriver();
    }

    String url = "https://www.amazon.in";

    @And("Webpage is launched")
    public void webpageIsLaunched() {
        driver.get(url);
    }

    @When("User enters the search string")
    public void userEntersTheSearchString() {
    }

    @And("User enters Submit button")
    public void userEntersSubmitButton() {
    }

    @Then("User should land in the search results page")
    public void userShouldLandInTheSearchResultsPage() {
    }

}
