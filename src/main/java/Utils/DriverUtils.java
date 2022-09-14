package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class DriverUtils {

    private DriverUtils(){}
    public static Properties prop;

    public static WebDriver getChromeDriverIncognito(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--incognito");
        DesiredCapabilities d = new DesiredCapabilities();
        d.setCapability(ChromeOptions.CAPABILITY, option);
        return new ChromeDriver(option.merge(d));
    }
    public static ChromeOptions enableChromeIncognito(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--incognito");
        DesiredCapabilities d = new DesiredCapabilities();
        d.setCapability(ChromeOptions.CAPABILITY, option);
        return option.merge(d);
    }
    public static void setChromePath() {

        System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
    }

    public static void setTimeout(WebDriver d, int ms){
        //This timeout is used to specify the amount of time the driver
        // should wait while searching for an element if it is not immediately present.
        d.manage().timeouts().implicitlyWait(Duration.ofMillis(ms));

        //This is used to set the amount of time the WebDriver must wait for an asynchronous
        // script to finish execution before throwing an error.
        d.manage().timeouts().scriptTimeout(Duration.ofMillis(ms));

        //This sets the time to wait for a page to load completely before throwing an error.
        // If the timeout is negative, page loads can be indefinite.
        d.manage().timeouts().pageLoadTimeout(Duration.ofMillis(ms));
    }
    public static void scrollToElement(WebDriver driver, WebElement el){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
    }


    public static void scroll(WebDriver driver, int scrollPixel){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+scrollPixel+")", "");
    }
    public static void scrollToElementAndClick(WebDriver driver, By selector){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(selector));
        driver.findElement(selector).click();
    }


    public static Properties initializeProperties() {
        if (prop != null)
            return prop;
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("demoqa.properties");
            prop.load(ip);
        } catch (Exception e) {
            System.out.println("Exception occurred during config initialization. " + e.getMessage());
            Reporter.log("Failed to load properties file. Error: " + e.getMessage());
        }
        return prop;
    }

    public static WebDriver getWebDriver() {
        if (prop == null)
            initializeProperties();
        String browser = prop.getProperty("browser");
        WebDriver driver;
        if (browser == null || browser.equalsIgnoreCase("Chrome")) {
            driver = WebDriverManager.chromedriver().create();
        } else if (browser.equalsIgnoreCase("headless")) {
            System.out.println("Setting headless browser");
            var chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--window-size=1280,800");
            chromeOptions.addArguments("--allow-insecure-localhost");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = WebDriverManager.safaridriver().create();
        } else if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("mozilla")) {
            driver = WebDriverManager.firefoxdriver().create();
        } else {
            driver = WebDriverManager.chromedriver().create();
        }
        return driver;
    }
//    public static void waitAndClick(WebDriver driver, By elementSelector, int ms){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ms));
//        wait.until(ExpectedConditions.elementToBeClickable(elementSelector));
//        DriverUtils.scrollToElementAndClick (driver, elementSelector);
//    }

    public static void scrollAndClick(WebDriver driver, String cssSelector){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(cssSelector)));
        driver.findElement(By.cssSelector(cssSelector)).click();
    }
    public static void scrollToTheEnd(WebDriver driver){
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }


}

