package Pages;

import Utils.DriverUtils;
import org.openqa.selenium.By;

public class BasePage {
    public By mainHeader = new By.ByCssSelector(".main-header");
    public By footerText = new By.ByCssSelector("footer span");
    public By logo = new By.ByCssSelector("header img");
    //public String baseUrl = DriverUtils.initializeProperties().getProperty("baseUrl");
}
