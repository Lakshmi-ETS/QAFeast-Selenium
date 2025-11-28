package com.tests;

import com.base.BaseClass;
import com.pages.CheckboxPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class CheckBoxTest extends BaseClass {
    CheckboxPage checkboxPage;
    boolean summaryStatus;
    boolean detailedStatus;
    boolean weeklyStatus;
    String actualSelectedMessage;
    String expectedSelectedMessage;

    @BeforeMethod
    public void navigateToCheckBox()
    {
        openApp();
        checkboxPage=new CheckboxPage(driver);
        checkboxPage.clickCheckBoxMenu();
    }
    @Test(groups={"title"})
    public void tc01_VerifyPageTitle()
    {
        String actualPageTitle=checkboxPage.getPageTitle();
        String expectedPageTitle="Checkbox";
        Assert.assertEquals(actualPageTitle,expectedPageTitle);
    }
    @Test(groups={"status"})
    public void tc02_VerifyCheckboxOnPageLoad()
    {
        summaryStatus=checkboxPage.getSummaryReportStatus();
        detailedStatus=checkboxPage.getDetailedReportStatus();
        weeklyStatus=checkboxPage.getWeeklyReportStatus();
        Assert.assertFalse(summaryStatus,"Summary Report should not be selected");
        Assert.assertFalse(detailedStatus,"Detailed report should not be selected");
        Assert.assertFalse(weeklyStatus,"Weekly report should not be selected");
    }
    @Test(groups={"functional"})
    public void tc03_VerifySummaryReportCheckBox()
    {
        checkboxPage.clickSummaryReport();
        summaryStatus=checkboxPage.getSummaryReportStatus();
        detailedStatus=checkboxPage.getDetailedReportStatus();
        weeklyStatus=checkboxPage.getWeeklyReportStatus();
        actualSelectedMessage=checkboxPage.getSelectedMessage();
        expectedSelectedMessage="Summary report is selected.";
        Assert.assertTrue(summaryStatus,"Summary Report should be selected");
        Assert.assertFalse(detailedStatus,"Detailed report should not be selected");
        Assert.assertFalse(weeklyStatus,"Weekly report should not be selected");
        Assert.assertEquals(actualSelectedMessage,expectedSelectedMessage);
    }
    @Test (groups={"functional"})
    public void tc04_VerifyDetailedReportCheckbox()
    {
        checkboxPage.clickDetailedReport();
        summaryStatus=checkboxPage.getSummaryReportStatus();
        detailedStatus=checkboxPage.getDetailedReportStatus();
        weeklyStatus=checkboxPage.getWeeklyReportStatus();
        actualSelectedMessage=checkboxPage.getSelectedMessage();
        expectedSelectedMessage="Detailed report is selected.";
        Assert.assertFalse(summaryStatus,"Summary Report should not be selected");
        Assert.assertTrue(detailedStatus,"Detailed report should be selected");
        Assert.assertFalse(weeklyStatus,"Weekly report should not be selected");
        Assert.assertEquals(actualSelectedMessage,expectedSelectedMessage);
    }
    @Test (groups={"functional"})
    public void tc05_VerifyWeeklyReportCheckbox()
    {
        checkboxPage.clickWeeklyReport();
        summaryStatus=checkboxPage.getSummaryReportStatus();
        detailedStatus=checkboxPage.getDetailedReportStatus();
        weeklyStatus=checkboxPage.getWeeklyReportStatus();
        actualSelectedMessage=checkboxPage.getSelectedMessage();
        expectedSelectedMessage="Weekly report is selected.";
        Assert.assertFalse(summaryStatus,"Summary Report should not be selected");
        Assert.assertFalse(detailedStatus,"Detailed report should not be selected");
        Assert.assertTrue(weeklyStatus,"Weekly report should be selected");
        Assert.assertEquals(actualSelectedMessage,expectedSelectedMessage);
    }
    @Test (groups={"functional"})
    public void tc06_VerifySelectionOfTwoReports_Summary_Weekly()
    {
        checkboxPage.clickSummaryReport();
        checkboxPage.clickWeeklyReport();
        summaryStatus=checkboxPage.getSummaryReportStatus();
        detailedStatus=checkboxPage.getDetailedReportStatus();
        weeklyStatus=checkboxPage.getWeeklyReportStatus();
        actualSelectedMessage=checkboxPage.getSelectedMessage();
        expectedSelectedMessage="Summary report,Weekly report is selected.";
        Assert.assertTrue(summaryStatus,"Summary Report should be selected");
        Assert.assertFalse(detailedStatus,"Detailed report should not be selected");
        Assert.assertTrue(weeklyStatus,"Weekly report should be selected");
        Assert.assertEquals(actualSelectedMessage,expectedSelectedMessage);
    }
    @Test (groups={"functional"})
    public void tc07_VerifySelectionOfTwoReports_Summary_Detailed()
    {
        checkboxPage.clickSummaryReport();
        checkboxPage.clickDetailedReport();
        summaryStatus=checkboxPage.getSummaryReportStatus();
        detailedStatus=checkboxPage.getDetailedReportStatus();
        weeklyStatus=checkboxPage.getWeeklyReportStatus();
        actualSelectedMessage=checkboxPage.getSelectedMessage();
        expectedSelectedMessage="Summary report,Detailed report is selected.";
        Assert.assertTrue(summaryStatus,"Summary Report should be selected");
        Assert.assertTrue(detailedStatus,"Detailed report should be selected");
        Assert.assertFalse(weeklyStatus,"Weekly report should not be selected");
        Assert.assertEquals(actualSelectedMessage,expectedSelectedMessage);
    }
    @Test (groups={"functional","status"})
    public void tc08_VerifySelectionOfTwoReports_Weekly_Detailed()
    {
        checkboxPage.clickWeeklyReport();
        checkboxPage.clickDetailedReport();
        summaryStatus=checkboxPage.getSummaryReportStatus();
        detailedStatus=checkboxPage.getDetailedReportStatus();
        weeklyStatus=checkboxPage.getWeeklyReportStatus();
        actualSelectedMessage=checkboxPage.getSelectedMessage();
        expectedSelectedMessage="Detailed report,Weekly report is selected.";
        Assert.assertFalse(summaryStatus,"Summary Report should not be selected");
        Assert.assertTrue(detailedStatus,"Detailed report should be selected");
        Assert.assertTrue(weeklyStatus,"Weekly report should be selected");
        Assert.assertEquals(actualSelectedMessage,expectedSelectedMessage);
    }
    @Test(groups = {"status","functional"})
    public void tc09_VerifySelectionOfAllReports()
    {
        checkboxPage.clickSummaryReport();
        checkboxPage.clickWeeklyReport();
        checkboxPage.clickDetailedReport();
        summaryStatus=checkboxPage.getSummaryReportStatus();
        detailedStatus=checkboxPage.getDetailedReportStatus();
        weeklyStatus=checkboxPage.getWeeklyReportStatus();
        actualSelectedMessage=checkboxPage.getSelectedMessage();
        expectedSelectedMessage="Summary report,Detailed report,Weekly report is selected.";
        Assert.assertTrue(summaryStatus,"Summary Report should be selected");
        Assert.assertTrue(detailedStatus,"Detailed report should be selected");
        Assert.assertTrue(weeklyStatus,"Weekly report should be selected");
        Assert.assertEquals(actualSelectedMessage,expectedSelectedMessage);
    }
    @Test(groups = {"functional","status"})
    public void tc10_VerifyDeselectionOfReports()
    {
        checkboxPage.clickSummaryReport();
        checkboxPage.clickDetailedReport();
        checkboxPage.clickSummaryReport();
        summaryStatus=checkboxPage.getSummaryReportStatus();
        detailedStatus=checkboxPage.getDetailedReportStatus();
        weeklyStatus=checkboxPage.getWeeklyReportStatus();
        actualSelectedMessage=checkboxPage.getSelectedMessage();
        expectedSelectedMessage="Detailed report is selected.";
        Assert.assertFalse(summaryStatus,"Summary report should be deselected");
        Assert.assertTrue(detailedStatus,"Detailed report should remain selected");
    }
    @AfterMethod
    public void closeWindow() {
        closeApp();
    }
}
