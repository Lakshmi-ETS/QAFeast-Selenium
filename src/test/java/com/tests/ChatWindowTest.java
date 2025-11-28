package com.tests;

import com.base.BaseClass;
import com.pages.ChatWindowPage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ChatWindowTest extends BaseClass {

    ChatWindowPage chatWindowPage;
    String filepath = "D:\\Lakshmi\\QAFeast\\TestData.xlsx";
    String sheetName = "ChatWindowPage";

    @BeforeMethod
    public void launchUrl() {
        openApp();
        chatWindowPage = new ChatWindowPage(driver);
        getMenu("Chat Window");

    }

    @AfterMethod
    public void closeWindow() {
        closeApp();
    }

    @DataProvider(name = "chatWindowData")
    public Object[][] getChatwindowData() throws IOException {
        FileInputStream fis = new FileInputStream(filepath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        DataFormatter dataFormatter = new DataFormatter();
        int rows = sheet.getLastRowNum();
        int columns = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Cell cell = sheet.getRow(i + 1).getCell(j);
                data[i][j] = dataFormatter.formatCellValue(cell);
            }
        }
        workbook.close();
        fis.close();
        return data;
    }
    @Test
    public void tc01_VerifyLogin() throws IOException {
        List<Map<String,String>> chatWindowPageData=readExcelData("D:\\Lakshmi\\QAFeast\\TestData.xlsx","ChatWindowPage");
        for(Map<String,String> testData:chatWindowPageData) {
            //chatWindowPage.moveToUsername();
            chatWindowPage.enterUserName(testData.get("username"));
            chatWindowPage.enterPassword(testData.get("password"));
            chatWindowPage.clickCheckBox();
            chatWindowPage.clickSignInBtn();
            chatWindowPage.clearUsername();
            chatWindowPage.clearPassword();
        }
    }
    @Test(dataProvider ="chatWindowData")
    public void tc02_VerifyChatWindow(String username,String password,String chatmessage)
    {
        chatWindowPage.clickChatBtn();
        chatWindowPage.enterMessage(chatmessage);
        chatWindowPage.clickSendBtn();

    }
}
