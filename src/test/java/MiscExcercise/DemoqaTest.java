package MiscExcercise;

import Utils.DriverUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;


public class DemoqaTest {

    static WebDriver kaher;

    @BeforeClass //a
    void setup(){
        DriverUtils.setChromePath();
        kaher = new ChromeDriver();
        kaher.manage().window().maximize();
        kaher.get("https://demoqa.com/text-box");
    }
    @Test (priority = 1) //b
    void testTitle(){
        //String myTitle = kaher.getTitle();
        Assert.assertEquals(kaher.getTitle(), "ToolsQA");
    }
    @Test (priority = 2) //c
    void verifyLogoVisibility(){
        WebElement logo = kaher.findElement(By.cssSelector("#app > header > a > img"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test (priority = 3) //d
    void validateFooter (){
        WebElement footer = kaher.findElement(By.cssSelector("#app > footer > span"));
        String footerName = footer.getText();
        System.out.println(footerName);
        Assert.assertTrue(footerName.contains("TOOLSQA.COM"));

    }
    @Test (priority = 4) // e
    static void testingTextBoxPage(){
        Faker faker = new Faker(new Locale("en-US"));
        //kaher.get("https://demoqa.com/text-box");
        WebElement kName = kaher.findElement(By.cssSelector("#userName"));
        kName.sendKeys(faker.name().fullName());

        //WebElement email = kaher.findElement(By.cssSelector("#userEmail"));
        String email = faker.name().username() + faker.number().randomDigit() + "@gmail.com";
        kaher.findElement(By.cssSelector("#userEmail")).sendKeys(email);

        WebElement address = kaher.findElement(By.cssSelector("#currentAddress"));
        address.sendKeys(faker.address().fullAddress());

        WebElement pAddress= kaher.findElement(By.cssSelector("#permanentAddress"));
        pAddress.sendKeys(faker.address().fullAddress());

//        JavascriptExecutor js = (JavascriptExecutor) kaher;
//        js.executeScript("window.scrollBy(0,350)", "");
        DriverUtils.scroll(kaher, 350);

        kaher.findElement(By.cssSelector("#submit")).click();
        WebElement result = kaher.findElement(By.cssSelector("#output"));
        Assert.assertTrue(result.isDisplayed());
    }
//   @Test (priority = 5) //f
//    void submitButton(){
//        WebElement button = kaher.findElement(By.cssSelector("#submit"));
//        Assert.assertTrue(button.isDisplayed());
//    }

    @AfterClass
    void wrapUp(){
        kaher.quit();
    }


    }