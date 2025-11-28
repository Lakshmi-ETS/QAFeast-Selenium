package com.pages;

import com.base.BaseClass;
import com.base.ReusablePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextboxPage extends ReusablePage {

    public TextboxPage(WebDriver driver)
    {
        super(driver);
    }
    private By usernameField=By.cssSelector("input[value='Enter username']");
    public void typeInEditableTextbox(String text)
    {
        enterText(By.xpath("//div[@class='form-group']/child::label[text()='Editable Text box:']/following-sibling::input"),text);
    }
    public String getTextOfEditableField()
    {
        return getElementAttribute(By.xpath("//div[@class='form-group']/child::label[text()='Editable Text box:']/following-sibling::input"),"value");
    }
    public void clearUsernameField()
    {
        clearText(usernameField);

    }
    public void typeInUsernameField(String text)
    {
        enterText(usernameField,text);
    }
    public String getTextUsernameField()
    {
        return getElementAttribute(usernameField,"value");
    }
    public boolean getNonEditableBtnStatus()
    {
       return isElementEnabled(By.cssSelector("#noteditabletext"));
    }
    public void clickTextboxMenu()
    {
      clickElement(By.xpath("//label[text()='Textbox']"));
    }
    public String getPageTitle()
    {
        return getElementText(By.xpath("//h2[text()='Textbox']"));
    }
}

