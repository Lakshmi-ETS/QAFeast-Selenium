package com.tests;

import com.base.BaseClass;
import com.pages.HyperlinkPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Set;

public class HyperlinkTest extends BaseClass {
    HyperlinkPage hyperlinkPage;
   @BeforeMethod
    public void navigateToHyperLink()
    {
        openApp();
        hyperlinkPage=new HyperlinkPage(driver);
        hyperlinkPage.clickHyperlinkMenu();
    }
    @Test(groups={"title"})
    public void tc01_VerifyPageTitle()
    {

        String actualPageTitle=hyperlinkPage.getPageTitle();
        String expectedPageTitle="Hyperlink";
        Assert.assertEquals(actualPageTitle,expectedPageTitle);
    }
    @Test(groups={"text"})
    public void tc02_VerifyLinkTexts()
    {
        String actualBrowserLinkText=hyperlinkPage.getBrowserLinkText();
        String expectedBrowserLinkText="Web browser automation";
        String actualDesktopLinkText=hyperlinkPage.getDesktopLinkText();
        String expectedDesktopLinkText="Desktop automation";
        Assert.assertEquals(actualBrowserLinkText,expectedBrowserLinkText);
        Assert.assertEquals(actualDesktopLinkText,expectedDesktopLinkText);
    }
    @Test(groups = {"functional"})
    public void tc03_VerifyBrowserLink()
    {
        hyperlinkPage.clickBrowserLink();
        String parentWindow=hyperlinkPage.getCurrentWindowHandle();
        Set<String> allWindows=hyperlinkPage.getAllWindowHandles();
        for(String handle:allWindows)
        {
        if(!parentWindow.equals(handle))
        {
            hyperlinkPage.switchWindow(handle);
            String actualChildUrl=hyperlinkPage.getCurrentURL();
            String expectedChildUrl="https://www.selenium.dev/";
            Assert.assertEquals(actualChildUrl,expectedChildUrl);
            closeCurrentWindow();
            break;
        }
        }
        hyperlinkPage.switchToWindow(parentWindow);
    }
    @Test(groups = {"functional"})
    public void tc04_VerifyDesktopLink()
    {
        hyperlinkPage.clickDesktopLink();
        String parentWindow=hyperlinkPage.getCurrentWindowHandle();
        Set<String> allWindows=hyperlinkPage.getAllWindowHandles();
        for(String handle:allWindows)
        {
            if(!parentWindow.equals(handle))
            {
                hyperlinkPage.switchWindow(handle);
                String actualChildUrl=hyperlinkPage.getCurrentURL();
                String expectedChildUrl="https://www.opentext.com/?o=mf";
                Assert.assertEquals(actualChildUrl,expectedChildUrl);
                break;
            }
        }
        hyperlinkPage.switchWindow(parentWindow);
    }
    @AfterMethod
    public void closeWindow()
    {
        closeApp();
    }

}
