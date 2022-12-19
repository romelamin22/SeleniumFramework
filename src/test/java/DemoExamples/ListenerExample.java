package DemoExamples;

import listeners.DriverListeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class ListenerExample {

    @Test
    public void testListeners() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);

        DriverListeners listeners = new DriverListeners();

        eventDriver.register(listeners);

        Thread.sleep(5000);
        eventDriver.get("https://google.com");

        eventDriver.findElement(By.xpath("//div[@class='RNNXgb']")).sendKeys("hello");

        eventDriver.close();
        eventDriver.quit();

    }


}
