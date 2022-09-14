package Demo_QA;

import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demoqa_Homepage {
    static WebDriver mahian;


    @BeforeClass
    void setup(){
        DriverUtils.setChromePath();
        mahian = new ChromeDriver();
        mahian.get("https://demoqa.com/");
    }
    @Test (priority = 1)
    void navigateToElements(){
        mahian.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(1) > div > div.avatar.mx-auto.white > svg")).click();

    }

}
