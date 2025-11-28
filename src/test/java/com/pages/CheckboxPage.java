package com.pages;

import com.base.BaseClass;
import com.base.ReusablePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckboxPage extends ReusablePage {
    public CheckboxPage(WebDriver driver)
    {
        super(driver);
    }
    public void  clickCheckBoxMenu()
    {
        clickElement(By.xpath("//label[text()='Checkbox']"));
    }
    public String getPageTitle()
    {
     return getElementText(By.xpath("//h2[text()='Checkbox']"));
    }
    public void clickSummaryReport()
    {
        clickElement(By.cssSelector("input[type='Checkbox'][value='Summary report']"));
    }
    public void clickDetailedReport()
    {
        clickElement(By.cssSelector("input[type='Checkbox'][value='Detailed report']"));
    }
    public void clickWeeklyReport()
    {
        clickElement(By.cssSelector("input[type='Checkbox'][value='Weekly report']"));
    }
    public String getSelectedMessage()
    {
        waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#msgbutton-3")));
        return getElementText(By.cssSelector("#msgbutton-3"));
    }
    public boolean getSummaryReportStatus()
    {
        return isElementSelected(By.cssSelector("input[type='Checkbox'][value='Summary report']"));
    }
    public boolean getWeeklyReportStatus()
    {
        return isElementSelected(By.cssSelector("input[type='Checkbox'][value='Weekly report']"));
    }
    public boolean getDetailedReportStatus()
    {
        return isElementSelected(By.cssSelector("input[type='Checkbox'][value='Detailed report']"));
    }
    public boolean getReportStatusByName(String name)
    {
        return isElementSelected(By.cssSelector("input[type='Checkbox'][value='"+name+" report']"));
    }

}
