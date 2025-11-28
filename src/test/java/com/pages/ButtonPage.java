package com.pages;

import com.base.BaseClass;
import com.base.ReusablePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ButtonPage  extends ReusablePage {

    public ButtonPage(WebDriver driver)
    {
        super(driver);
    }
    public void clickSubmitBtn()
    {
        clickElement(By.cssSelector("#button-1"));
    }
    public void clickOrderBtn()
    {
        waitForElement().until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button-2")));
        clickElement(By.cssSelector("#button-2"));
    }
    public String getSubmitBtnMsg()
    {
        return getElementText(By.cssSelector("#msgbutton-1"));
    }

    public String getPageTitle()
    {
        return getElementText(By.xpath("//h2[text()='Button']"));
    }

}


