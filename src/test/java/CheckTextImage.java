import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created by vse on 26.09.17.
 * Don't copy without link.
 */
public class CheckTextImage {

    private WebDriver webDriver;
    private static final String URL = "https://jdi-framework.github.io/tests/index.htm";

    @DataProvider(parallel = true)
    public Object[][] correctData() {

        return new Object[][]{
                {0, "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM projec"},
                {1, "To be flexible and\n" +
                        "customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"},
        };
    }

    @Test(groups = "positive",dataProvider = "correctData")
    public void check(int index, String text){
        webDriver.navigate().to(URL);
        //div.col-sm-3:nth-child(1) > div:nth-child(1) > span:nth-child(2)
        WebElement textSpan = webDriver.findElements(By.cssSelector("span.benefit-txt")).get(index);
        Assert.assertEquals(textSpan.getText(),text);
    }

    @BeforeMethod
    public void setUp(Method method){
        webDriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver","chromedriver");
        System.setProperty("webdriver.gecko.driver","geckodriver");
    }

    @AfterMethod
    public void stop(){

        webDriver.close();
    }
}
