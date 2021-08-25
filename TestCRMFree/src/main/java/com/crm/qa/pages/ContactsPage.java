package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement titleDropdown;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='surname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath="//input[@value='Load From Company']//following-sibling::input[@value='Save']")
	WebElement saveContact;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public Boolean validateContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling"
				+ "::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title, String fname, String lname, String com) {
		Select titleDrop = new Select(titleDropdown);
		titleDrop.selectByVisibleText(title);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		company.sendKeys(com);
		saveContact.click();
	}
	
	
}
