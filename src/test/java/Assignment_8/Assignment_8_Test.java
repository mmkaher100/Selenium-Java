package Assignment_8;

import Utils.DriverUtils;
import Utils.ExcelUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import Pages.Assignment_8_Pages;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Assignment_8_Test {

    WebDriver driver;
    Assignment_8_Pages page = new Assignment_8_Pages();

    static final String EXCEL_FILE_PATH = System.getProperty("user.dir") + "/Resources/Test_Data/Mock_Data.xlsx";


    @BeforeClass
    void setUp(){
        driver = DriverUtils.getWebDriver();
        driver.manage().window().maximize();

    }
    @DataProvider(name= "loadFromData")
    public static Object[][] dataLoad() throws Exception {
        return ExcelUtils.getTableArray(EXCEL_FILE_PATH);
    }

    @Test (dataProvider = "loadFromData")
    void test(double id, String fName, String lName, String gender, String dob, String ssn, String phone, String email) throws InterruptedException {
        driver.get(page.pageUrl);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(3000);
        email = fName+"."+lName +"@gmail.com";
        driver.findElement(page.customizedCashRewardClick).click();
        Thread.sleep(3000);

        driver.findElement(page.firstName).sendKeys(fName);
        Thread.sleep(3000);

        driver.findElement(page.lastName).sendKeys(lName);
        Thread.sleep(3000);

        Faker faker = new Faker(new Locale("en-US"));

        driver.findElement(page.address1).sendKeys(faker.address().streetAddress());

        driver.findElement(page.city).sendKeys(faker.address().city());

        List<WebElement> states = driver.findElements(page.state);
        Random random = new Random();
        int i= random.nextInt(states.size()-11);
        String state = states.get(i).getAttribute("value");
        states.get(i).click();
        Thread.sleep(3000);

        driver.findElement(page.zipCode).sendKeys(faker.address().zipCodeByState(state));

        driver.findElement(page.phoneNumber).sendKeys(phone);

        DriverUtils.scrollToElementAndClick(driver, page.typeOfPhone);


        driver.findElement(page.email).sendKeys(email);

        driver.findElement(page.saveAndContinue).click();
        Thread.sleep(2000);

        //page 2
        DriverUtils.scrollToElementAndClick(driver, page.usCitizen);
        Thread.sleep(2000);
        driver.findElement(page.ssNumber).sendKeys(ssn);
        Thread.sleep(2000);

        driver.findElement(page.residency).click();
        Thread.sleep(2000);

        driver.findElement(page.dualCitizen).click();
        Thread.sleep(2000);

        driver.findElement(page.dateOfBirth).sendKeys(dob);

        driver.findElement(page.saveAndConitue2).click();

        //page 3
        Thread.sleep(3000);
        driver.findElement(page.employmentStatus).click();
        Thread.sleep(2000);

        driver.findElement(page.occupation).click();
        Thread.sleep(2000);
        driver.findElement(page.annualIncome).sendKeys("20000");
        Thread.sleep(2000);

        driver.findElement(page.sourceOfIncome).click();
        Thread.sleep(2000);

        driver.findElement(page.monthlyHousingPayment).sendKeys("500");
        Thread.sleep(2000);

        driver.findElement(page.saveAndContinue3).click();

        //page 4
        Thread.sleep(2000);
        driver.findElement(page.termsAndCondition).click();
        Thread.sleep(2000);

        driver.findElement(page.saveAndContinue4).click();
        Thread.sleep(2000);

       WebElement review = driver.findElement(page.reviewInfo);
       Assert.assertTrue(review.isDisplayed());





        Thread.sleep(2000);


    }
}
