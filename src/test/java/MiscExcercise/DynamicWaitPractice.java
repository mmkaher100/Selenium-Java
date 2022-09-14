package MiscExcercise;

import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicWaitPractice {

    static WebDriver driver;

    @BeforeClass
    void setUp(){
        DriverUtils.setChromePath();
        driver = new ChromeDriver();
        DriverUtils.setTimeout(driver, 10000);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading");

    }
    @Test(priority = 1)
    void example1() throws InterruptedException {
        driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#start > button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByCssSelector("div#finish")));
        WebElement helloWorld= driver.findElement(By.cssSelector("div#finish"));
        Assert.assertTrue(helloWorld.getText().contains("Hello World!"));
        driver.navigate().back();
    }
    @Test(priority = 2)
    void example2() throws InterruptedException {
        driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#start > button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByCssSelector("div#finish")));
        WebElement helloWorld= driver.findElement(By.cssSelector("div#finish"));
        Assert.assertTrue(helloWorld.getText().contains("Hello World!"));


    }
}
