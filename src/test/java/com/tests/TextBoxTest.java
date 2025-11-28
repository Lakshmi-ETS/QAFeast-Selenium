package com.tests;

import com.base.BaseClass;
import com.pages.TextboxPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TextBoxTest extends BaseClass {

    TextboxPage textBoxPage;
    public String expectedPageTitle="Textbox";
    public String actualPageTitle;

    @AfterMethod
    public void closeWindow()
    {
        closeApp();
    }
    @BeforeMethod
    public void navigateToTextBox()
    {
        openApp();
        textBoxPage=new TextboxPage(driver);
        textBoxPage.clickTextboxMenu();

    }
    @Test(groups={"title","text"})
    public void tc01_verifyPageTitle()
    {
        actualPageTitle=textBoxPage.getPageTitle();
        Assert.assertEquals(actualPageTitle,expectedPageTitle);
    }
    @Test(groups={"functional"})
    public void tc03_verifyEditableTextbox() {
        textBoxPage.typeInEditableTextbox("Test Edit");
        String actualTextEntered = textBoxPage.getTextOfEditableField();
        String expectedText = "Test Edit";
        Assert.assertEquals(actualTextEntered, expectedText);
    }
    @Test(groups = {"functional"})
    public void tc02_verifyNonEditableBox()
    {
        boolean textBoxStatus=textBoxPage.getNonEditableBtnStatus();
        Assert.assertFalse(textBoxStatus);
    }
    @Test(groups = {"functional"})
    public void tc04_verifyUsernameBox()
    {
        String textBefore=textBoxPage.getTextUsernameField();
        Assert.assertNotNull(textBefore);
        textBoxPage.clearUsernameField();
        String textAfter=textBoxPage.getTextUsernameField();
        Assert.assertEquals(textAfter,"");
        textBoxPage.typeInUsernameField("Test user");
        String actualText=textBoxPage.getTextUsernameField();
        String expectedText="Test user";
        Assert.assertEquals(actualText,expectedText);
    }
    @Test
    public void readData() throws IOException {
        List<Map<String,String>> excelData =readExcelData("D:\\Lakshmi\\QAFeast\\TestData.xlsx","Sample");
        for(Map<String,String> rowData:excelData) {
            for (Map.Entry<String, String> entry : rowData.entrySet()) {
                System.out.println("Key: " + entry.getKey());
                System.out.println("Value: " + entry.getValue());
            }
        }
    }
}
