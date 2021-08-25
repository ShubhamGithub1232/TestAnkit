package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Object Repository
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signupBtn;
	
	@FindBy(xpath="//img[@src='https://classic.freecrm.com/img/logo@2x.png']")
	WebElement crmLogo;
	
	//Initializing Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String valdiateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMIMage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		
		loginBtn.click();
		return new HomePage();
	}
}
