package Tests;

import Utilities.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName){

        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",
                    "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver",
                    "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("InternetExplorer")){
            System.setProperty("webdriver.ie.driver",
                    "drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @AfterSuite
    public void closeDriver(){
        driver.quit();
    }

    //Take Screenshot when testcase fails and add it to Screenshot directory
    @AfterMethod
    public void screenShotOnFailure(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            System.out.println("Failed to take screenshot");
            System.out.println("Taking Screenshot!");
            Helper.captureScreenshot(driver,result.getName());
        }
    }
}
