package DemoExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class IframeExample {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public void switchToIframe(WebElement frame){

        wait.until(ExpectedConditions.visibilityOf(frame));
        driver.switchTo().frame(frame);

    }

    public void switchToParentApplication(){

        driver.switchTo().defaultContent();

    }

    @Test
    public void iframeExample() throws InterruptedException {

        driver.get("https://scaledupit.com/test");
        driver.manage().window().maximize();

        WebElement xFrame = driver.findElement(By.xpath("//iframe[@title='Test Iframe']"));

        switchToIframe(xFrame);

        driver.findElement(By.id("bmwradio")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("hondaradio")).click();

        switchToParentApplication();

        Thread.sleep(3000);

        driver.findElement(By.id("bmwradio")).click();
        Thread.sleep(3000);


    }

}
