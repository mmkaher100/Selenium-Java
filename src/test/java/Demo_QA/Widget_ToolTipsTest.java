package Demo_QA;

import Pages.Widget_ToolTipsPage;
import Utils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class Widget_ToolTipsTest {

    WebDriver driver;
    Widget_ToolTipsPage widget_toolTipsPage = new Widget_ToolTipsPage();

    @BeforeClass
    void setUp(){
       // DriverUtils.setChromePath();
        driver = DriverUtils.getWebDriver();
        driver.manage().window().maximize();
        driver.get(widget_toolTipsPage.pageUrl);

    }
    @Test
    void contraryTest() throws InterruptedException {
        Thread.sleep(4000);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(widget_toolTipsPage.contrarySelector));
        actions.click().build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(widget_toolTipsPage.contraryHov));

        Assert.assertTrue(element.getText().contains("You hovered over the Contrary"));
        Thread.sleep(10000);
    }
    @AfterClass
    void wrapUp(){
        driver.quit();
    }
}
