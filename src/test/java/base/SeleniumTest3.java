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



public class SeleniumTest3 {
    private WebDriver webDriver;

    @BeforeSuite
    public void setUpSuite() {
        System.setProperty("webdriver.gecko.driver", "geckodriver");
    }


    @BeforeTest
    public void setUpTest() {
    }


    @BeforeClass
    public void setUp() {
        webDriver = new FirefoxDriver();
    }

    @Test(groups = "Smoke")
    public void testTitle1() {
        webDriver.navigate().to(EPAM_INDEX_URL);
        Assert.assertEquals(webDriver.getTitle(),EPAM_INDEX_TITLE);
    }

    @Test(groups = "Regression")
    public void testTitle2() {
        webDriver.navigate().to(EPAM_INDEX_URL);
        Assert.assertEquals(webDriver.getTitle(),EPAM_INDEX_TITLE);
    }

    @Test(groups = "Regression")
    public void testTitle3() {
        webDriver.navigate().to(EPAM_INDEX_URL);
        Assert.assertEquals(webDriver.getTitle(),EPAM_INDEX_TITLE);
    }

    @Test(groups = "Smoke")
    public void testTitle4() {
        webDriver.navigate().to(EPAM_INDEX_URL);
        Assert.assertEquals(webDriver.getTitle(),EPAM_INDEX_TITLE);
    }

    @AfterClass
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
