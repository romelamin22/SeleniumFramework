package data_model;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class DataModelExample {

    public HashMap<String, String> readXl(String xlPath, String sheetName) throws IOException {

        HashMap<String, String> data = new HashMap<>();

        String path = xlPath;

        FileInputStream fis = new FileInputStream(path);

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet ws = wb.getSheet(sheetName);

        int rows = ws.getLastRowNum()+1;
        int cols = ws.getRow(1).getLastCellNum();

        String[][] tempData = new String[rows][cols];

        for (int r = 1; r < rows; r++){

            XSSFRow myRow = ws.getRow(r);

            for (int c = 0; c<cols; c++){

                XSSFCell cell = myRow.getCell(c);
                String value = getCellData(cell);
                tempData[r][c] = value;

            }

        }
        for (String[] row : tempData ){

            String key = row[0];
            String value = row[1];
            data.put(key, value);

        }

        return data;

    }

    public static String getCellData(Cell cellValue){

        String value;

        DataFormatter formatter = new DataFormatter();

        try {

            value = formatter.formatCellValue(cellValue);

        }catch (Exception e){

            value = "";

        }

        return value;

    }

    public static void main(String[] args) throws IOException, InterruptedException{

        DataModelExample obj = new DataModelExample();
        String path = "D:\\_Class\\my Files\\Excel Files\\DataModelWithHashMap.xlsx";
        String sheet = "Sheet1";

        HashMap<String, String> testData = obj.readXl(path, sheet);

        System.out.println(testData.get("SearchTerm"));
        System.out.println(testData.get("LastName"));

        WebDriver driver = new ChromeDriver();

        driver.get("https://scaledupit.com/test2.html");
        driver.manage().window().maximize();
        String fn = testData.get("FirstName");
        String ln = testData.get("LastName");

        driver.findElement(By.id("userm")).sendKeys(fn);
        driver.findElement(By.id("passm")).sendKeys(ln);

        Thread.sleep(5000);


    }

}
