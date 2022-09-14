package Pages;

import org.openqa.selenium.By;

public class Elements_RadioButton_Page {
    public By yesRadio = new By.ByCssSelector("label[for='yesRadio']");
    public By successMessage = new By.ByCssSelector(".text-success");

    public By noRadio = new By.ByCssSelector("#noRadio");

    public String pageURL= ("https://demoqa.com/radio-button");
}
