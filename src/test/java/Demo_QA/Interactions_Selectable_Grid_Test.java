package Demo_QA;

import Pages.Interactions_Selectable_Grid_Page;
import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Interactions_Selectable_Grid_Test {
    WebDriver driver;
    Interactions_Selectable_Grid_Page gridPage = new Interactions_Selectable_Grid_Page();
    @BeforeClass
    void setup() throws InterruptedException {
        DriverUtils.setChromePath();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(gridPage.pageUrl);
        Thread.sleep(5000);
        //Clicking on the grid tab
        //WebElement gridTab = driver.findElement(By.cssSelector("#demo-tab-grid"));
        //gridTab.click();
        WebElement gridTab = driver.findElement(gridPage.gridTabLocation);
        gridTab.click();

    }
    @Test
    void testGrid(String selector) throws InterruptedException {
        WebElement box = driver.findElement(By.cssSelector(selector));
        box.click();
        Thread.sleep(1000);
        Assert.assertTrue(box.getAttribute("class").contains("active"));
        box.click();
        Thread.sleep(1000);
        Assert.assertFalse(box.getAttribute("class").contains("active"));
        box.click();
        Thread.sleep(1000);

    }
}
