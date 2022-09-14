package MiscExcercise;

import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileDownloadTest {
    WebDriver driver;

    @BeforeClass
    void setUp(){
        driver = DriverUtils.getWebDriver();
        driver.get("http://the-internet.herokuapp.com/upload");
    }

    @Test
    void fileUploadTest(){
        WebElement fileUpload = driver.findElement(By.cssSelector("#file-upload"));
        //String absolutePath = DriverUtils.initializeProperties("user.dir").getProperty
    }
}
