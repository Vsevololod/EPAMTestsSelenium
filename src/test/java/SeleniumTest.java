import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by vse on 11.09.17.
 * Don't copy without link.
 */


public class SeleniumTest {
    @Test
    public void test2() {
        System.setProperty("webdriver.gecko.driver","geckodriver");

        WebDriver webDriver = new FirefoxDriver();
        webDriver.navigate().to("https://www.epam.com/");

        //WebElement element = webDriver.findElement(By.xpath("//*[@class='tile-menu']//*[@href='/solutions']"));

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("alert('test')");

        //Assert.assertEquals(webDriver.getTitle(),"EPAM | Software Product Development Services");
        webDriver.close();

    }
}
