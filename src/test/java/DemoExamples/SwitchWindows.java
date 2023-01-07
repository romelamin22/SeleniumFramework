package DemoExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class SwitchWindows {

    WebDriver driver = new ChromeDriver();

    public void switchToWindow(){

        String mainWindow = driver.getWindowHandle();

        Set<String> openWindows = driver.getWindowHandles();

        for (String window: openWindows){

            if (!window.equals(mainWindow)){

                driver.switchTo().window(window);

            }

        }

    }

    @Test
    public void switchWindowTest() throws InterruptedException {

        driver.get("https://scaledupit.com/test3");
        driver.manage().window().maximize();
        //open window
        driver.findElement(By.id("openwindow")).click();

        //even though focus is on the new window selenium driver is still on the old window
        //we have to explicitly tell selenium driver to focus on the new window

        switchToWindow();

        Thread.sleep(3000);

        Assert.assertEquals(driver.getTitle(), "Nike. Just Do It. Nike.com");

    }



}
