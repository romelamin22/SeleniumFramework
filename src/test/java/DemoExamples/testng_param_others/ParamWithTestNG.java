package DemoExamples.testng_param_others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class ParamWithTestNG {

    WebDriver driver;

    WebDriverWait wait;

    @BeforeTest
    @Parameters({"browser", "url"})
    public void lunchBrowser(String browser, String url){

        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();

        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.manage().window().maximize();

        driver.get(url);

    }

    @Test(priority = 2)
    public void test1(){

        driver.findElement(By.linkText("About")).click();

    }

    @Test(priority = 1)
    public void test2(){

        driver.findElement(By.linkText("Advertising")).click();

    }

    @AfterTest
    public void tearDown(){

        if (driver instanceof ChromeDriver){
            driver.quit();
        }else {
            driver.close();
        }

    }
}
