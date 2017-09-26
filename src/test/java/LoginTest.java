import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


/**
 * Created by vse on 13.09.17.
 * Don't copy without link.
 *
 * Create a new test in a new Java class,
 * specify test name accordingly checking functionality
 */
public class LoginTest {
    private WebDriver webDriver;

    public LoginTest(){


    }

    @BeforeMethod
    public void setUp(Method method){
        webDriver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver","chromedriver");
        System.setProperty("webdriver.gecko.driver","geckodriver");
        System.out.println(method.getName());
    }

    @AfterMethod
    public void stop(){
        webDriver.close();
    }

    @Test(groups = "positive")
    public void positiveTest(){
        //Open test site by URL

        webDriver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        //Assert Browser title
        Assert.assertEquals(webDriver.getTitle(),"Index page");


        //Perform login
        WebElement dropDownButton = webDriver.findElement(By.cssSelector("li.uui-profile-menu .dropdown-toggle"));
        WebElement loginInput = webDriver.findElement(By.cssSelector("#Login"));
        WebElement passInput = webDriver.findElement(By.cssSelector("#Password"));
        WebElement enterButton = webDriver.findElement(By.cssSelector("button.uui-button:nth-child(2)"));

        webDriver.manage().window().maximize();
        dropDownButton.click();
        loginInput.sendKeys("epam");
        passInput.sendKeys("1234");
        enterButton.click();



        //Assert User name in the left-top side of screen that user is loggined
        WebElement userNameElement = webDriver.findElement(By.cssSelector(".profile-photo > span:nth-child(3)"));
        Assert.assertTrue(userNameElement.isDisplayed());
        Assert.assertEquals(userNameElement.getText(),"Piter Chailovskii");


        //Open Contact form
        WebElement contactForm = webDriver.findElement(By.cssSelector("ul.uui-navigation:nth-child(3) > li:nth-child(2) > a:nth-child(1)"));
        contactForm.click();
        //Assert Browser title
        Assert.assertEquals(webDriver.getTitle(),"Index page");


        //Input your first and last name in text fields and click submit button
        WebElement fName = webDriver.findElement(By.cssSelector("#Name"));
        WebElement lName = webDriver.findElement(By.cssSelector("#LastName"));
        WebElement subButton = webDriver.findElement(By.cssSelector("div.text-right:nth-child(2) > button:nth-child(1)"));
        WebElement logPlace = webDriver.findElement(By.cssSelector(".logs"));

        fName.sendKeys("First name");
        lName.sendKeys("Last Name");
        subButton.click();

        Assert.assertTrue(
                logPlace.findElement(By.cssSelector("li:first-child")).getText().contains("submit")
        );
    }
}
