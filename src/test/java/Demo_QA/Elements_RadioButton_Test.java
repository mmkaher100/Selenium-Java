package Demo_QA;

import Pages.Elements_RadioButton_Page;
import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Elements_RadioButton_Test {
    WebDriver driver;
    Elements_RadioButton_Page radioButton_page = new Elements_RadioButton_Page();

    @BeforeClass
    void setUp(){
        DriverUtils.setChromePath();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(radioButton_page.pageURL);
    }
    @Test (priority = 1)
    void testYesRadio() throws InterruptedException {
        driver.findElement(radioButton_page.yesRadio).click();
        String sMessage = driver.findElement(radioButton_page.successMessage).getText();
        Assert.assertTrue(sMessage.contains("Yes"));
        Thread.sleep(3000);


    }
    @Test (priority = 2)
    void testNoRadio() throws InterruptedException {
        WebElement no = driver.findElement((radioButton_page.noRadio));
        Assert.assertFalse(no.isEnabled());
        Thread.sleep(3000);
    }
    @AfterClass
    void WrapUp(){
        driver.quit();
    }
}
