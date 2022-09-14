package Assignment_7;

import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoQA_Login {
    WebDriver driver;

    @BeforeClass
    void setUp(){
        driver = DriverUtils.getWebDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/register");
    }
    @Test
    void testRegister() throws InterruptedException {
        driver.findElement(By.cssSelector("#register")).click();
        Thread.sleep(5000);

        WebElement firstNameBox = driver.findElement(By.cssSelector("#firstname"));
        Assert.assertTrue(firstNameBox.getAttribute("class").contains("invalid"));

        WebElement lastNameBox = driver.findElement(By.cssSelector("#lastname"));
        Assert.assertTrue(lastNameBox.getAttribute("class").contains("invalid"));

        WebElement userNameBox = driver.findElement(By.cssSelector("#userName"));
        Assert.assertTrue(userNameBox.getAttribute("class").contains("invalid"));

        WebElement passwordBox = driver.findElement(By.cssSelector("#password"));
        Assert.assertTrue(passwordBox.getAttribute("class").contains("invalid"));
    }
    @AfterClass
    void wrapUp(){
        driver.quit();
    }

}
