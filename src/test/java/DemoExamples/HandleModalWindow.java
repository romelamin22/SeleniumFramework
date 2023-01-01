package DemoExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandleModalWindow {

    WebDriver driver = new ChromeDriver();

    @Test
    public void modalExample() throws InterruptedException {

        driver.get("https://scaledupit.com/test2.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("one")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("close")).click();
        driver.findElement(By.id("userm")).sendKeys("Romel");
        Thread.sleep(3000);
    }

    @Test
    public void modalExampleTwo() throws InterruptedException {

        driver.get("https://scaledupit.com/test3.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());

        //String alertTxt = driver.switchTo().alert().getText();
        //System.out.println(alertTxt);
        //driver.switchTo().alert().accept();//click on ok

        driver.switchTo().alert().dismiss();//click on cancel

        Thread.sleep(2000);
    }

    @Test
    public void modalWindowWithGoogle() throws InterruptedException {

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        WebElement xFrame = driver.findElement(By.xpath("//iframe[@name='callout']"));
        Thread.sleep(3000);

        driver.switchTo().frame(xFrame);

        WebElement signInPopUp = driver.findElement(By.xpath("//button[@aria-label='No thanks']"));

        signInPopUp.click();

        Thread.sleep(3000);

    }
}
