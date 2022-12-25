package DemoExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class ListWebElementExample{

    @Test
    public void testList() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://scaledupit.com/test3");
        driver.manage().window().maximize();

        List<WebElement> le = driver.findElements(By.xpath("//div[@id='radio-btn-example']//label//input"));

        for (WebElement e: le){

            if (e.getAttribute("value").equalsIgnoreCase("bmw")){

                e.click();
            }

        }
        Thread.sleep(3000);



    }

}
