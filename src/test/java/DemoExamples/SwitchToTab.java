package DemoExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class SwitchToTab {

    WebDriver driver = new ChromeDriver();

    public void switchToTab(){

        String mainTab = driver.getWindowHandle();

        Set<String> openWindows = driver.getWindowHandles();

        for (String window: openWindows){

            if (!window.equals(mainTab)){

                driver.switchTo().window(window);

            }

        }

    }

    @Test
    public void switchTabTest() throws InterruptedException {

        driver.get("https://scaledupit.com/test3");
        driver.manage().window().maximize();
        //open window
        driver.findElement(By.id("opentab")).click();

        switchToTab();

        Thread.sleep(2000);

        Assert.assertEquals(driver.getTitle(), "Amazon.com. Spend less. Smile more.");

    }
}
