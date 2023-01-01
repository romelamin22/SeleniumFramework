package DemoExamples.js_execute;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptExecute {

    @Test
    public void testOne() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.get("https://scaledupit.com/test2.html");

        //driver.findElement(By.id("userm")).sendKeys("Ahmed");
        js.executeScript("document.getElementById('userm').value ='Ahmed';");
        Thread.sleep(2000);
        js.executeScript("document.getElementById('passm').value ='Khalil';");
        Thread.sleep(2000);
        js.executeScript("document.getElementById('sone').click();");
        Thread.sleep(2000);
        js.executeScript("alert('Hello everyone, you completed entering firstname and last name using js');");
        Thread.sleep(5000);

    }

    @Test
    public void scrollBy() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);
        //js.executeAsyncScript("window.scrollBy(0,600)", "");
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        //The syntax of ScrollBy() methods is :
        // executeScript("window.scrollBy(x-pixels,y-pixels)");

    }



}
