package com.pages;

import com.base.ReusablePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChatWindowPage extends ReusablePage {
    public ChatWindowPage(WebDriver driver)
    {
        super(driver);
    }
   public void moveToUsername()
   {
     moveToElement(By.cssSelector("#username"));
   }
    public void enterUserName(String userName)
    {
        //waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username")));
        enterText(By.xpath("(//input[@id='username'])[2]"),userName);
    }
    public void enterPassword(String password)
    {
        enterText(By.xpath("(//input[@id='pwd'])[2]"),password);
    }
    public void clickCheckBox()
    {
        clickElement(By.xpath("(//label[text()=' Remember me'])[2]"));
    }
    public void clickSignInBtn()
    {
         clickElement(By.xpath("//button[text()='Sign In']"));
    }
    public void clickChatBtn()
    {
       clickElement(By.cssSelector("#openchatform"));
    }
    public void enterMessage(String msg)
    {
        enterText(By.cssSelector("textarea[name='msg']"),msg);
    }
    public void clickSendBtn()
    {
        clickElement(By.xpath("//button[text()='Send']"));
    }
    public void clickCloseBtn()
    {
        clickElement(By.cssSelector("#closechatform"));
    }
    public void clearUsername()
    {
        clearText(By.xpath("(//input[@id='username'])[2]"));
    }
    public void clearPassword()
    {
        clearText(By.xpath("(//input[@id='pwd'])[2]"));
    }
}
