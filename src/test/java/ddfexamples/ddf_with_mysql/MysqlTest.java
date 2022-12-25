package ddfexamples.ddf_with_mysql;

import config.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.sql.*;

public class MysqlTest {

    public ResultSet resultSet;

    public MysqlTest() {

        Configuration config = new Configuration();
        String conUrl = config.prop.getProperty("jdbcUrl");
        String conUser = config.prop.getProperty("jdbcUser");
        String conPass = config.prop.getProperty("jdbcPass");
        try {

            Connection con = DriverManager.getConnection(conUrl, conUser, conPass);

            Statement q = con.createStatement();
            ResultSet resultSet = q.executeQuery("Select * from sakila.login");

            this.resultSet= resultSet;

        }catch (SQLException se){

            se.printStackTrace();
        }
    }

    @Test
    public void jdbcTest() throws SQLException, InterruptedException {

        while (resultSet.next()){

            WebDriver driver = new ChromeDriver();

            driver.get("https://scaledupit.com/test2.html");

            driver.manage().window().maximize();

            String username = resultSet.getString("username");
            String pass = resultSet.getString("password");

            driver.findElement(By.id("userm")).sendKeys(username);

            driver.findElement(By.id("passm")).sendKeys(pass);

            driver.findElement(By.id("sone")).click();

            Thread.sleep(3000);

            driver.quit();

        }

    }



}
