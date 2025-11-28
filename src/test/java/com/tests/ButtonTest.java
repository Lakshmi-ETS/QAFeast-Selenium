package com.tests;

import com.base.BaseClass;
import com.pages.ButtonPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.devtools.v136.page.Page.captureScreenshot;

public class ButtonTest extends BaseClass {

    ButtonPage buttonPage;
    public String expectedPageTitle = "Button Page";
    public String actualPageTitle;

    @BeforeMethod
    public void launchApp() {
        openApp();
        buttonPage=new ButtonPage(driver);
        getMenu("Button");
        //buttonPage.clickBtnMenu();
    }
   @AfterMethod(alwaysRun = true)
    public void afterTest(ITestResult result) {
        Reporter.setCurrentTestResult(result);
        if (result.getStatus() == ITestResult.FAILURE) {
            String desPath = "D:\\Lakshmi\\QAFeast\\Screenshot\\" + result.getName() + ".png";
            captureScreenshot(desPath);
            System.setProperty("org.uncommons.reportng.escape-output", "false");
            Reporter.log("Test Failed: " + result.getName());
            Reporter.log("<br><a href='" + desPath + "' target='_blank'>"+ "Click here to open screenshot</a>");
            Reporter.log("<br><img src='" + desPath + "' height='400' width='600'/><br>");
        }
        closeCurrentWindow();
    }
    //@AfterMethod
    public void afterTestAction(ITestResult testResult)
    {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
            Reporter.setCurrentTestResult(testResult);
            Reporter.log(testResult.getName()+" Test failed");
            String desPath = "D:\\Lakshmi\\QAFeast\\Screenshot\\" + testResult.getName() + ".png";
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(src, new File(desPath));
                System.out.println("<img src=\"" + desPath + "\" alt=\"Failed screenshot\">");
            } catch (IOException e) {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
            }
            System.setProperty("org.uncommons.reportng.escape-output", "false");
            Reporter.log("<img src=\"" + desPath + "\" alt=\"Failed screenshot\">");
            Reporter.log("Test failed");
        }
            closeCurrentWindow();
    }

    @Test(groups={"title"})
    public void tc01_verifyPageTitle() {
        actualPageTitle = buttonPage.getPageTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
    }
    @Test(groups = {"functional"})
    public void tc02_verifySubmitBtn() {
        buttonPage.clickSubmitBtn();
        String actualSuccessMessage = buttonPage.getSubmitBtnMsg();
        String expectedSuccessMessage = "Submit button is clicked";
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
    }
}
