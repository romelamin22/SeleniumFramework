package ddfexamples.with_xl;

import config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class XLWithDataProvider {

    @DataProvider(name = "ExcelDP")
    public Object[][] dataP() throws IOException {

        Configuration config = new Configuration();
        XLReader xlr = new XLReader();
        String myXlPath = config.prop.getProperty("xlPath");
        String mySheet = config.prop.getProperty("sheetName");

        Object[][] data =  xlr.readXl(myXlPath, mySheet);

        return data;

    }

    @Test(dataProvider = "ExcelDP")
    public void testOne(String fname, String lname) throws InterruptedException {

        if (!(fname==null) && !(lname == null)){

            WebDriver driver = new ChromeDriver();
            driver.get("https://scaledupit.com/test2.html");
            driver.manage().window().maximize();
            driver.findElement(By.id("userm")).sendKeys(fname);
            driver.findElement(By.id("passm")).sendKeys(lname);
            driver.findElement(By.id("sone")).click();

            Thread.sleep(5000);

        }

    }


}
