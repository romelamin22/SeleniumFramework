package DemoExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNGListenerExample {

    WebDriver driver = new ChromeDriver();

    @Test
    public void testAmazon(){

        System.out.println("This is Amazon test");
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("blinds");
        driver.quit();

    }

    @Test
    public void testGoogle(){

        System.out.println("This is Google test");
        driver.get("https://google.com");
        driver.findElement(By.xpath("//div[@class='RNNXgb']")).sendKeys("blinds");
        driver.quit();

    }

    @Test
    public void testAutomation(){

        System.out.println("This is Automation test");

        driver.get("https://automation.scaledupit.com/");
        driver.quit();

    }

}
