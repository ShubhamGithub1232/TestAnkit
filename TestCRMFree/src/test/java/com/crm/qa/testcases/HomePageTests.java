package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTests extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public HomePageTests() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void validateLoginUser() {
		testUtil.switchToFrame();
		String loginUser = homePage.validateLoginUser();
		Assert.assertEquals(loginUser.replaceAll(" ", ""), "User:SanjuBaba");
	}
	
	@Test(priority=2)
	public void validateContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickContactsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
