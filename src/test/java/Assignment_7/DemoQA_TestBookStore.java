package Assignment_7;

import Utils.DriverUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static Utils.ReadProperties.*;

public class DemoQA_TestBookStore {

    WebDriver driver;

    @BeforeClass
    void setUp() throws IOException {
        driver = DriverUtils.getWebDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
    }

    @Test (priority =1)
    void testDynamic() throws IOException, InterruptedException {
        driver.findElement(By.cssSelector("#userName")).sendKeys(getUsername());
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("#password")).sendKeys(getPassword());
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("#login")).click();
        Thread.sleep(3000);

        WebElement profile = driver.findElement(By.cssSelector(".pattern-backgound.playgound-header"));
        Assert.assertTrue(profile.isDisplayed());
        // clicking on Bookstore
        DriverUtils.scrollAndClick(driver, ".element-group:nth-child(6) #item-2");
        Thread.sleep(2000);


        List<WebElement> bookList = driver.findElements(By.cssSelector(".mr-2"));

        DriverUtils.scrollToTheEnd(driver);

        String lastBookName = bookList.get(bookList.size() - 1).getText();
        bookList.get((bookList.size()) - 1).click();
        Thread.sleep(5000);

        // adding to Collection
        DriverUtils.scrollAndClick(driver,"#app div.mt-2.fullButtonWrap.row div.text-right.fullButton" );


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent()).accept();

        driver.get("https://demoqa.com/profile");
        Assert.assertTrue(driver.findElement(By.cssSelector(".rt-table")).getText().contains(lastBookName));



    }

    @Test (priority = 2)
    void testRandom() throws IOException, InterruptedException {


        WebElement profile = driver.findElement(By.cssSelector(".pattern-backgound.playgound-header"));
        Assert.assertTrue(profile.isDisplayed());
        // clicking on Bookstore
        DriverUtils.scrollAndClick(driver, ".element-group:nth-child(6) #item-2");
        Thread.sleep(2000);


        List<WebElement> bookList = driver.findElements(By.cssSelector(".mr-2"));
        Faker f = new Faker();

        int n = f.random().nextInt(0, bookList.size()-1);
        DriverUtils.scrollToElement(driver, bookList.get(n));
        String randomBookName= bookList.get(n).getText();
        bookList.get(n).click();

        // adding to Collection
        DriverUtils.scrollAndClick(driver,"#app div.mt-2.fullButtonWrap.row div.text-right.fullButton" );

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent()).accept();

        driver.get("https://demoqa.com/profile");
        Assert.assertTrue(driver.findElement(By.cssSelector(".rt-table")).getText().contains(randomBookName));

    }
    @AfterClass
    void wrapUp(){
        driver.quit();
    }

}

