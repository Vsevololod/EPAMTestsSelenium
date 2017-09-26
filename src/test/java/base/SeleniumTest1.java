package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import static com.vse.main.GlobalConstants.*;

/**
 * Created by vse on 11.09.17.
 * Don't copy without link.
 */



public class SeleniumTest1 {
    private WebDriver webDriver;

    @BeforeSuite
    public void setUpSuite() {
        System.setProperty("webdriver.gecko.driver", "geckodriver");
    }

    @Test(groups = "Smoke")
    public void testTitle1() {
        WebDriver wd = new FirefoxDriver();
        wd.navigate().to(EPAM_INDEX_URL);
        Assert.assertEquals(wd.getTitle(),EPAM_INDEX_TITLE);
        wd.close();
        if (webDriver.toString().contains("null")) {
            webDriver.quit();
        }
    }

}
