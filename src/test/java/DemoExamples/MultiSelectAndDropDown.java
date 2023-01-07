package DemoExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MultiSelectAndDropDown {

    @Test
    public void multiTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://scaledupit.com/test3");
        driver.manage().window().maximize();

      /*  Select cars = new Select(driver.findElement(By.id("carselect")));

        Thread.sleep(3000);

        cars.selectByVisibleText("Benz");

        Thread.sleep(3000);
*/
        //multi select example
        Select multiSelect = new Select(driver.findElement(By.id("multiple-select-example")));

        Thread.sleep(3000);

        if (multiSelect.isMultiple()) {

            multiSelect.selectByVisibleText("Apple");
            multiSelect.selectByVisibleText("Peach");

            Thread.sleep(3000);
        }else {

            System.out.println("it is not multi selectable");
        }

    }



}
