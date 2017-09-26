import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by vse on 11.09.17.
 * Don't copy without link.
 */



public class SeleniumTest {
    private WebDriver webDriver;

    @BeforeSuite
    public void setUpSuite() {
        System.setProperty("webdriver.gecko.driver", "geckodriver");
    }


    @BeforeTest
    public void setUpTest() {
    }


    @BeforeMethod
    public void setUp() {
        webDriver = new FirefoxDriver();
    }

    @Test(groups = "main", invocationCount = 2, invocationTimeOut = 10000)
    public void test2() {
        webDriver.navigate().to("https://www.epam.com/");
    }

    @AfterMethod
    public void after() {
        webDriver.close();
    }

    @AfterSuite
    public void exitSuite() {
        if (webDriver.toString().contains("null")) {
            webDriver.quit();
        }
    }

}
