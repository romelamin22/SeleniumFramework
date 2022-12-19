package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateExtentReports {

    public WebDriver driver;
    public ExtentSparkReporter spark;
    public ExtentReports extent;
    public ExtentTest logger;

    @BeforeTest
    public void startReport() throws IOException {

        extent = new ExtentReports();

        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/TestReports.html");

        extent.attachReporter(spark);

        //For design purposes
        extent.setSystemInfo("Host Name", "Software Testing");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Romel");
        spark.config().setDocumentTitle("TestReports");
        spark.config().setTheme(Theme.DARK);
    }


    public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {

            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

            TakesScreenshot ts = (TakesScreenshot) driver;

            File source = ts.getScreenshotAs(OutputType.FILE);

            String destination = System.getProperty("user.dir") + "\\Screeshot\\" + screenshotName + dateName + ".png";

            File finalDestination = new File(destination);

            FileUtils.copyFile(source, finalDestination);

            return destination;

    }

    @BeforeMethod
    public void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://amazon.com");

    }

    @Test
    public void verifyTitle() {

        logger = extent.createTest("verifyTitle");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("blinds");

        Assert.assertEquals(driver.getTitle(),"Amazon.com. Spend less. Smile more.");

    }

    @Test
    public void verifyGoogle(){

        logger = extent.createTest("verifyGoogle");

        driver.get("https://google.com");

        driver.findElement(By.id("hasdgjf")).click();

        Assert.assertEquals(driver.getTitle(), "hello");


    }

    @AfterMethod
    public void getResult(ITestResult result) throws Exception {

        if (result.getStatus() == ITestResult.FAILURE){

            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ "Test Case Failed", ExtentColor.RED));

            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " Test case Failed ", ExtentColor.RED));

            String screenshotPath = getScreenshot(driver, result.getName());

            logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));

        } else if (result.getStatus() == ITestResult.SKIP) {

            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped ", ExtentColor.ORANGE));

        } else if (result.getStatus() == ITestResult.SUCCESS) {

            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test case Passed", ExtentColor.GREEN));

        }

        driver.quit();

    }

    @AfterTest
    public void endReport(){

        extent.flush();

    }


}
