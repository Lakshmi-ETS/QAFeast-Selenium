package com.base;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class BaseClass {
    public WebDriver driver;

    public void openApp() {
        driver = new ChromeDriver();
        Reporter.log("Navigating to QAFeast demo website");
        driver.get("https://www.qafeast.com/demo");
        driver.manage().window().maximize();
    }

    public void closeApp() {
        driver.quit();
    }

    public void closeCurrentWindow() {
        driver.close();
    }

    public void getMenu(String menuName) {
        driver.findElement(By.xpath("//label[text()='" + menuName + "']")).click();
    }

    public void captureScreenshot(String path) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(path));
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    public List<Map<String, String>> readExcelData(String filePath, String sheetName) throws IOException {

        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        DataFormatter formatter = new DataFormatter();
        List<Map<String, String>> fileData = new ArrayList<>();
        List<String> headers = new ArrayList<>();
        Row rowHeader = sheet.getRow(0);
        int row = sheet.getLastRowNum();
        int column = sheet.getRow(0).getLastCellNum();
        for (Cell cell : rowHeader) {
            headers.add(formatter.formatCellValue(cell));
        }
        //Both column assignments are correct
        column=headers.size();
        for (int i = 1; i <= row; i++) {
            Map<String,String> currentRowData=new HashMap<>();
            for (int j = 0; j < column; j++) {

                Cell cell = sheet.getRow(i).getCell(j);
                currentRowData.put(headers.get(j), formatter.formatCellValue(cell));
            }
            fileData.add(currentRowData);
        }
        workbook.close();
        fis.close();
        return  fileData;
    }
}
