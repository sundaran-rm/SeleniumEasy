package StepDefinitions;

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
    //Simple Form
    By simpleFormLink =  By.xpath("//body/div[@id='easycont']/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]");
    By singleInputBox = By.xpath("//input[@id='user-message']");
    By showMessageButton = By.xpath("//button[contains(text(),'Show Message')]");
    By resultMessage = By.xpath("//span[@id='display']");
    By input1 = By.xpath("//input[@id='sum1']");
    By input2 = By.xpath("//input[@id='sum2']");
    String inputValue1 ="4";
    String inputValue2 ="5";
    By getTotalButton = By.xpath("//button[contains(text(),'Get Total')]");
    By displayTotal = By.xpath("//span[@id='displayvalue']");
    //Radio Form
    By radioFormLink = By.xpath("//body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/a[3]");
    By radioButtonMale = By.xpath("//body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/label[1]/input[1]");
    By radioButtonGroupFemale = By.xpath("//body[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/label[2]/input[1]");
    By radioButtonAgeGroup = By.xpath("//body[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/label[2]/input[1]");
    By checkValueButton = By.id("buttoncheck");
    By getValueButton = By.xpath("//body[1]/div[2]/div[1]/div[2]/div[2]/div[2]/button[1]");
    By checkResults = By.xpath("//body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/p[3]");
    By groupText = By.xpath("//body[1]/div[2]/div[1]/div[2]/div[2]/div[2]/p[2]");

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

    @And("User enters a and b values")
    public void userEntersAAndBValues() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(input1)));
        driver.findElement(input1).sendKeys(inputValue1);
        driver.findElement(input2).sendKeys(inputValue2);

    }

    @And("User clicks on Get Total Button")
    public void userClicksOnGetTotalButton() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(getTotalButton)));
        driver.findElement(getTotalButton).click();
    }

    @Then("Total should be displayed")
    public void totalShouldBeDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(displayTotal)));
        String displayValue = driver.findElement(displayTotal).getText();
        Assert.assertEquals("9", displayValue);

    }

    @When("User clicks Radio Buttons Demo")
    public void userClicksRadioButtonsDemo() {
        wait.until(ExpectedConditions.elementToBeClickable(popupClose));
        driver.findElement(popupClose).click();

        wait.until(ExpectedConditions.elementToBeClickable(startPracticeButton));
        driver.findElement(startPracticeButton).click();

        wait.until(ExpectedConditions.elementToBeClickable(radioFormLink));
        driver.findElement(radioFormLink).click();

    }

    @And("User lands on the Radio Buttons Demo page")
    public void userLandsOnTheRadioButtonsDemoPage() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(radioButtonMale)));

    }

    @And("User clicks Male radio button")
    public void userClicksMaleRadioButton() {
        wait.until(ExpectedConditions.elementToBeClickable(radioButtonMale));
        driver.findElement(radioButtonMale).click();

        wait.until(ExpectedConditions.elementToBeClickable(checkValueButton));
        driver.findElement(checkValueButton).click();
    }

    @And("User clicks Female radio button with age group '5 to 15'")
    public void userClicksFemaleRadioButtonWithAgeGroupTo() {
        wait.until(ExpectedConditions.elementToBeClickable(radioButtonGroupFemale));
        driver.findElement(radioButtonGroupFemale).click();

        wait.until(ExpectedConditions.elementToBeClickable(radioButtonAgeGroup));
        driver.findElement(radioButtonAgeGroup).click();

        wait.until(ExpectedConditions.elementToBeClickable(getValueButton));
        driver.findElement(getValueButton).click();
    }

    @Then("Radio Buttons should be selected")
    public void radioButtonsShouldBeSelected() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(checkResults)));
        String displayText = driver.findElement(checkResults).getText();
        Assert.assertEquals("Radio button 'Male' is checked", displayText);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(groupText)));
        String displayGroupText = driver.findElement(groupText).getText();
        Assert.assertEquals("Sex : Female\n" +
                "Age group: 5 - 15", displayGroupText);
    }
}
