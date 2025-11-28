package com.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class ReusablePage implements ITestListener {
    private WebDriver driver;
    public ReusablePage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void clickElement(By by)
    {
        driver.findElement(by).click();
    }
    public void enterText(By by,String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    public String getElementText(By by)
    {
       return driver.findElement(by).getText();
    }
    public WebDriverWait waitForElement()
    {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public boolean isElementSelected(By by)
    {
        return driver.findElement(by).isSelected();
    }
    public void switchWindow(String handle)
    {
        driver.switchTo().window(handle);
    }
    public String getCurrentURL()
    {
        return driver.getCurrentUrl();
    }
    public String getElementAttribute(By by,String attribute)
    {
        return  driver.findElement(by).getAttribute(attribute);
    }
    public void clearText(By by)
    {
        driver.findElement(by).clear();
    }
    public boolean isElementEnabled(By by)
    {
        return driver.findElement(by).isEnabled();
    }
    public String getCurrentWindowHandle()
    {
        return driver.getWindowHandle();
    }
    public Set<String> getAllWindowHandles()
    {
        return driver.getWindowHandles();
    }
    public void  getMenu(String menuName)
    {
        clickElement(By.xpath("//label[text()='"+menuName+"']"));
    }
    public void moveToElement(By by)
    {
        Actions act=new Actions(driver);
        act.moveToElement(driver.findElement(by)).build().perform();
    }

}

