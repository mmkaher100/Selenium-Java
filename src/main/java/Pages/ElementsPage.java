package Pages;

import org.openqa.selenium.By;

public class ElementsPage extends BasePage{
    public By textBox_submenu = new By.ByCssSelector(".element-group:first-child li:nth-child(1)");

    public By checkbox_submenu = new By.ByCssSelector(".element-group:first-child li:nth-child(2)");

    public By radioButton_submenu = new By.ByCssSelector(".element-group:first-child li:nth-child(3)");

    public By webTables_submenu = new By.ByCssSelector(".element-group:first-child li:nth-child(4)");

    public By Buttons_submenu = new By.ByCssSelector(".element-group:first-child li:nth-child(5)");

    public By links_submenu = new By.ByCssSelector(".element-group:first-child li:nth-child(6)");

    public By brokenLinksImages_submenu = new By.ByCssSelector(".element-group:first-child li:nth-child(7)");

    public By uploadAndDownload_submenu = new By.ByCssSelector(".element-group:first-child li:nth-child(8)");

    public By dynamicProperties_submenu = new By.ByCssSelector(".element-group:first-child li:nth-child(9)");

    public static String pageUrl = "https://demoqa.com/elements";
}

//public class ElementsPage {
//    public String pageURL = ("https://demoqa.com/");
//
//    public  By elements = new By.ByCssSelector(".category-cards .card.mt-4.top-card:nth-child(1)");
//
//    public By textBox = new By.ByCssSelector(".btn.btn-light.active");
//
//    public By fullName = new By.ByCssSelector("#userName");
//
//    public By email = new By.ByCssSelector("#userEmail");
//
//    public By currentAddress = new By.ByCssSelector("#currentAddress");
//
//    public By permanentAddress = new By.ByCssSelector("#permanentAddress");
//
//    public By textBoxSubmit = new By.ByCssSelector("#submit");
//
//    public By textBoxSubmittedItem = new By.ByCssSelector(".border");
//
//    // Navigate to Check Box Elements
//    public By checkBox = new By.ByCssSelector(".element-list.collapse.show .btn.btn-light#item-1 .text");
//
//}
