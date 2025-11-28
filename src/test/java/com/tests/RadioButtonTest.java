package com.tests;

import com.base.BaseClass;
import com.pages.RadioButtonPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class RadioButtonTest extends BaseClass {

    RadioButtonPage radioBtnPage;
    boolean maleBtnStatus;
    boolean femaleBtnStatus;
    @AfterMethod
    public void closeWindow()
    {
        closeApp();
    }
    @BeforeMethod
    public void navigateToRadioBtnMenu()
    {
        openApp();
        radioBtnPage = new RadioButtonPage(driver);
        radioBtnPage.clickRadioBtnMenu();

    }
    @Test(groups={"title"})
    public void tc01_verifyPageTitle() {
        radioBtnPage.clickRadioBtnMenu();
        String actualPageTitle = radioBtnPage.getPageTitle();
        String expectedPageTitle = "Radio Button";
        Assert.assertEquals(actualPageTitle,expectedPageTitle);
    }
    @Test(groups={"status","functional"})
    public void tc02_selectMaleButton() {
        radioBtnPage.clickMaleButton();
        maleBtnStatus = radioBtnPage.getRadioBtnStatus("Male");
        femaleBtnStatus = radioBtnPage.getRadioBtnStatus("Female");
        String actualSelectedMessage = radioBtnPage.getSelectedMsg();
        String expectedSelectedMessage = "Male is selected";
        Assert.assertTrue(maleBtnStatus);
        Assert.assertFalse(femaleBtnStatus);
        Assert.assertEquals(actualSelectedMessage,expectedSelectedMessage);
    }
    @Test(groups={"status","functional"})
    public void tc03_selectFemaleButton() {
        radioBtnPage.clickFemaleButton();
        maleBtnStatus = radioBtnPage.getRadioBtnStatus("Male");
        femaleBtnStatus = radioBtnPage.getRadioBtnStatus("Female");
        String actualSelectedMessage = radioBtnPage.getSelectedMsg();
        String expectedSelectedMessage = "Female is selected";
        Assert.assertTrue(femaleBtnStatus);
        Assert.assertFalse(maleBtnStatus);
        Assert.assertEquals(actualSelectedMessage,expectedSelectedMessage);
    }
}
