package Demo_QA;

import Pages.Elements_TextBox_Page;
import Utils.DriverUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Elements_TextBox_Test {

    WebDriver driver;
    Elements_TextBox_Page elementsP = new Elements_TextBox_Page();

    @BeforeClass
    void setUp() {
        DriverUtils.setChromePath();
        driver = new ChromeDriver();
        //ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(elementsP.pageUrl);

    }
    @Test
    void textBox() throws InterruptedException {
        Faker faker = new Faker();
        String name =faker.name().name();
        String email = faker.name().username()+"@gmail.com";
        String currAdd = faker.address().fullAddress();
        String perAdd = faker.address().fullAddress();
        elementsP.populateFormAndClick(driver, name,email,currAdd, perAdd);
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(elementsP.output).getText().contains(name));

    }
    @AfterClass
    void wrapUp(){
        driver.quit();
    }
}