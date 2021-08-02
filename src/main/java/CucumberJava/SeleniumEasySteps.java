package CucumberJava;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class SeleniumEasySteps {
    WebDriver driver =null;
    WebDriverWait wait =null;
    private CommonSteps commonSteps;
    String url = "https://www.seleniumeasy.com/test/";
    By startPracticeButton = By.xpath("//a[@id='btn_basic_example']");
    By popupClose =  By.id("at-cv-lightbox-close");
    By simpleFormLink =  By.xpath("//body/div[@id='easycont']/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]");
    By singleInputBox = By.xpath("//input[@id='user-message']");
    By showMessageButton = By.xpath("//button[contains(text(),'Show Message')]");
    By resultMessage = By.xpath("//span[@id='display']");

    public SeleniumEasySteps (CommonSteps commonSteps) {
        this.commonSteps = commonSteps;
        driver = commonSteps.getDriver();
        wait = commonSteps.getWait();

    }

    @And("SE webpage is launched")
    public void seWebpageIsLaunched() {
        driver.get(url);
    }

    @When("User clicks Simple Form Demo")
    public void userClicksSimpleFormDemo() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(popupClose));
        driver.findElement(popupClose).click();

        wait.until(ExpectedConditions.elementToBeClickable(startPracticeButton));
        driver.findElement(startPracticeButton).click();

        wait.until(ExpectedConditions.elementToBeClickable(simpleFormLink));
        driver.findElement(simpleFormLink).click();
    }

    @And("User lands on the simple form demo page")
    public void userLandsOnTheSimpleFormDemoPage() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(singleInputBox)));
    }

    @And("User enters message text")
    public void userEntersMessageText() {
        driver.findElement(singleInputBox).sendKeys("Selenium");
    }

    @And("User clicks Show Message button")
    public void userClicksShowMessageButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(showMessageButton));
        driver.findElement(showMessageButton).click();
    }

    @Then("Message should be displayed")
    public void messageShouldBeDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(resultMessage));
        String text = driver.findElement(resultMessage).getText();
        Assert.assertEquals("Selenium", text);
    }
}
