package Demo_QA;

import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demoqa_List {

    static WebDriver driver;

    @BeforeClass
    void setup(){
        DriverUtils.setChromePath();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/selectable");

    }
    @Test
    void testingASingleList() throws InterruptedException {
        testList("#verticalListContainer li:nth-child(1)");

        testList("#verticalListContainer li:nth-child(2)");

        testList("#verticalListContainer li:nth-child(3)");

        testList("#verticalListContainer li:nth-child(4)");


    }

    void testList(String selector) throws InterruptedException {
        WebElement list =driver.findElement(By.cssSelector(selector));
        list.click();
        Assert.assertTrue(list.getAttribute("class").contains("active"));
        list.click();
        Thread.sleep(1000);
        Assert.assertFalse(list.getAttribute("class").contains("active"));
        //list.click();
        Thread.sleep(1000);


    }
    @AfterClass
    void wrapUp(){
        driver.quit();
    }
}
