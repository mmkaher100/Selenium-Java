package Pages;

import org.openqa.selenium.By;

public class Interactions_Selectable_Grid_Page {

    public String pageUrl = "https://demoqa.com/selectable";

    public By gridTabLocation = new By.ByCssSelector("#demo-tab-grid");

   public void testASingleGrid() throws InterruptedException {
        testGrid("#row1 li:nth-child(1");
        testGrid("#row1 li:nth-child(2");
        testGrid("#row1 li:nth-child(3");

        testGrid("#row2 li:nth-child(1");
        testGrid("#row2 li:nth-child(2");
        testGrid("#row2 li:nth-child(3");

        testGrid("#row3 li:nth-child(1");
        testGrid("#row3 li:nth-child(2");
        testGrid("#row3 li:nth-child(3");

    }

    private void testGrid(String s) {
    }
}
