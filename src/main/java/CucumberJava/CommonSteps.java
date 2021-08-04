package CucumberJava;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CommonSteps {

    private WebDriver driver = null;
    private WebDriverWait wait = null;

  //  private static boolean initialized = false;

    @Before
    public void setUp() throws Exception {
        if (driver == null) {
            // initialize the driver
            String path = System.getProperty("user.dir");
            System.out.println("Home Path: " + path);
            System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/drivers/chromedriver_mac.exe");
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 20);

     //       initialized = true;
        }

    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    @Given("Browser is open")
    public void browserIsOpen() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @And("Browser should close")
    public void browserShouldClose() {
        driver.close();
        driver.quit();
        driver = null;
    }
}
