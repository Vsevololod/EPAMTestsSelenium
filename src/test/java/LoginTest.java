import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by vse on 13.09.17.
 * Don't copy without link.
 */


public class LoginTest {

    public LoginTest(){

        System.setProperty("webdriver.chrome.driver","chromedriver");
        System.setProperty("webdriver.gecko.driver","geckodriver");
    }

    @Test
    public void positiveTest(){
        WebDriver webDriver = new FirefoxDriver();
        webDriver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        Assert.assertEquals(webDriver.getTitle(),"Index Page");


        WebElement dropDownButton = webDriver.findElement(By.cssSelector("li.uui-profile-menu .dropdown-toggle"));
        WebElement loginInput = webDriver.findElement(By.cssSelector("#Login"));
        WebElement passInput = webDriver.findElement(By.cssSelector("#Password"));
        WebElement enterButton = webDriver.findElement(By.cssSelector("button.uui-button:nth-child(2)"));


        webDriver.manage().window().maximize();
        dropDownButton.click();
        loginInput.sendKeys("epam");
        passInput.sendKeys("1234");
        enterButton.click();
        //Assert.assertTrue(dropdownButton.isDisplayed());

        webDriver.close();
    }
}
