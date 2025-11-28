package com.pages;

import com.base.BaseClass;
import com.base.ReusablePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RadioButtonPage extends ReusablePage {
    @FindBy(xpath="//label[text()='Radio Button']")
    private By radioBtnMenuField;
    @FindBy(xpath="//h2[text()='Radio Button']")
    private WebElement pageTitleField;
    @FindBy(css=".radio [value='Male is selected']")
    private WebElement maleOptionField;
    @FindBy(css=".radio [value='Female is selected']")
    private WebElement femaleOptionField;
    @FindBy(css="#msgbutton-2")
    private WebElement selectedOptionMsgField;
    public RadioButtonPage(WebDriver driver)
    {
        super(driver);
    }
    public void clickRadioBtnMenu()
    {
        waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Radio Button']")));
        clickElement(By.xpath("//label[text()='Radio Button']"));
    }
    public String getPageTitle()
    {
        return getElementText(By.xpath("//h2[text()='Radio Button']"));
    }
    public void clickMaleButton()
    {
        clickElement(By.cssSelector(".radio [value='Male is selected']"));
    }
    public void clickFemaleButton()
    {
        clickElement(By.cssSelector(".radio [value='Female is selected']"));
    }
    public boolean getRadioBtnStatus(String gender)
    {
        return isElementSelected(By.cssSelector(".radio [value='"+gender+" is selected']"));
    }
    public String getSelectedMsg()
    {
        waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#msgbutton-2")));
        return getElementText(By.cssSelector("#msgbutton-2"));
    }
}
