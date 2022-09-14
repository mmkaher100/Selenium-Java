package Demo_QA;

import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RadioButton {

    static WebDriver mahian;

    @BeforeClass
    void setup(){
        DriverUtils.setChromePath();
        mahian = new ChromeDriver();
        mahian.get("https://demoqa.com/radio-button");

    }
    @Test (priority = 1)
    void verifyYes(){
        WebElement yes = mahian.findElement(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > div:nth-child(2) > label"));
        if (yes.isEnabled()){
            yes.click();
            WebElement result = mahian.findElement(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > p"));
            Assert.assertTrue(result.getText().equals("You have selected Yes"));

        }
        else {
            System.out.println("Yes button is disabled");
        }
}
    @Test (priority = 2)
    void verifyImpressive(){
        WebElement impressive = mahian.findElement(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > div:nth-child(3) > label"));
        if (impressive.isEnabled()){
            impressive.click();
            WebElement result = mahian.findElement(By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > p"));
            Assert.assertTrue(result.getText().equals("You have selected Impressive"));
        }
        else {
            System.out.println("Impressive button is disabled");

        }
    }
    @Test (priority = 3)
    void verifyNo(){
        WebElement no = mahian.findElement(By.cssSelector( "#noRadio"));
        Assert.assertFalse(no.isEnabled());

    }
}
