package DemoExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionExample {

    @Test
    public void actionEx() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.nike.com/");
        driver.manage().window().maximize();

        WebElement nnf = driver.findElement(By.xpath("//button[@aria-label='New & Featured']"));
        WebElement ms = driver.findElement(By.xpath("//a[@aria-label='main-menu, New & Featured, New For Men, Shoes']"));

        Actions act = new Actions(driver);

        act.moveToElement(nnf).build().perform();

        Thread.sleep(3000);

        act.moveToElement(ms).click().build().perform();


    }

}
