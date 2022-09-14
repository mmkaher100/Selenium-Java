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

public class Demoqa_Grid {

    static WebDriver tanbir;

    @BeforeClass
    void setup() throws InterruptedException {
        //DriverUtils.setChromePath();
        tanbir = DriverUtils.getWebDriver();
        tanbir.manage().window().maximize();
        tanbir.get("https://demoqa.com/selectable");
        Thread.sleep(5000);
        //Clicking on the grid tab
        WebElement gridTab = tanbir.findElement(By.cssSelector("#demo-tab-grid"));
        gridTab.click();

    }
    @Test
    void testASingleGrid() throws InterruptedException {
        testGrid("#row1 li:nth-child(1");
        testGrid("#row1 li:nth-child(2");
        testGrid("#row1 li:nth-child(3");

        testGrid("#row2 li:nth-child(1");
        testGrid("#row2 li:nth-child(2");
        testGrid("#row2 li:nth-child(3");

        testGrid("#row3 li:nth-child(1");
        testGrid("#row3 li:nth-child(2");
        testGrid("#row3 li:nth-child(3");

    }
    void testGrid(String selector) throws InterruptedException {
        WebElement box = tanbir.findElement(By.cssSelector(selector));
        box.click();
        Thread.sleep(1000);
        Assert.assertTrue(box.getAttribute("class").contains("active"));
        box.click();
        Thread.sleep(1000);
        Assert.assertFalse(box.getAttribute("class").contains("active"));
        box.click();
        Thread.sleep(1000);

    }


   @AfterClass
   void wrapUp(){

        tanbir.quit();
   }


}
