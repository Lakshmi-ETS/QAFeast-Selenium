package com.pages;

import com.base.BaseClass;
import com.base.ReusablePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class HyperlinkPage extends ReusablePage {

    public HyperlinkPage(WebDriver driver)
    {
        super(driver);
    }
    public void clickHyperlinkMenu()
    {
        clickElement(By.xpath("//label[text()='Hyperlink']"));
    }
    public String getPageTitle()
    {
        return getElementText(By.xpath("//h2[text()='Hyperlink']"));
    }
    public String getBrowserLinkText()
    {
        return getElementText(By.xpath("//a[text()='Web browser automation']"));
    }
    public String getDesktopLinkText()
    {
        return getElementText(By.xpath("//a[text()='Desktop automation']"));
    }
    public void clickBrowserLink()
    {
        clickElement(By.xpath("//a[text()='Web browser automation']"));
    }
    public void clickDesktopLink()
    {
        clickElement(By.xpath("//a[text()='Desktop automation']"));
    }
    public void switchToWindow(String handle)
    {
        switchWindow(handle);
    }
    public String getCurrentWindow()
    {
        return getCurrentWindowHandle();
    }


}
