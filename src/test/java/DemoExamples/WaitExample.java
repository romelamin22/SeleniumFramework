package DemoExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class WaitExample {

    @Test
    public void testWait(){

        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");

        //driver.manage().window().maximize();

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        WebElement createAcc = fluentWait.until(new Function<WebDriver, WebElement>() {

            @Override
            public WebElement apply(WebDriver driver) {

                WebElement findElement = driver.findElement(By.id("auth-create-account-link"));

                return findElement;
            }
        });

        createAcc.click();

        //driver.quit();


    }

}
