package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.vse.main.GlobalConstants.EPAM_INDEX_TITLE;
import static com.vse.main.GlobalConstants.EPAM_INDEX_URL;

/**
 * Created by vse on 11.09.17.
 * Don't copy without link.
 */



public class SeleniumTest2 {
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

    @Test(groups = "Regression")
    public void testTitle1() {
        webDriver.navigate().to(EPAM_INDEX_URL);
        Assert.assertEquals(webDriver.getTitle(),EPAM_INDEX_TITLE);
    }

    @Test(groups = "Regression")
    public void testTitle2() {
        webDriver.navigate().to(EPAM_INDEX_URL);
        Assert.assertEquals(webDriver.getTitle(),EPAM_INDEX_TITLE);
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
