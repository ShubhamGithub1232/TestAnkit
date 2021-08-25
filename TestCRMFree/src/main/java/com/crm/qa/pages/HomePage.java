package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: Sanju Baba')]")
	WebElement loginUser;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContact;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginUser() {
		return loginUser.getText();
	}
	
	public ContactsPage clickContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public void clickOnNewContact() {
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
//		action.moveToElement(element).build().perform();
		Point pt = element.getLocation();
		action.moveByOffset(pt.getX(), pt.getY());
		action.moveToElement(element, pt.getX(), pt.getY());
		newContact.click();
	}
}
