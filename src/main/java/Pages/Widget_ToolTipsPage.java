package Pages;

import org.openqa.selenium.By;

public class Widget_ToolTipsPage {

    public String pageUrl = "https://demoqa.com/tool-tips";

    public By contrarySelector = new By.ByCssSelector("#texToolTopContainer a:nth-child(1)");

    public By contraryHov = new By.ByCssSelector(".tooltip-inner");
}
