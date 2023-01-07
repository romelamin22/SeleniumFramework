package DemoExamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotClass {

    @Test
    public void robotTest(){

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.nike.com/");
        driver.manage().window().maximize();

        try {
            Robot r = new Robot();

            Thread.sleep(3000);
            //if you press a key with robot class you have to release it.

            r.keyPress(KeyEvent.VK_ALT);
            r.keyPress(KeyEvent.VK_F4);
            r.keyRelease(KeyEvent.VK_ALT);
            r.keyRelease(KeyEvent.VK_F4);

            Thread.sleep(3000);

        }catch (AWTException | InterruptedException e){

            e.getMessage();
        }



    }



}
