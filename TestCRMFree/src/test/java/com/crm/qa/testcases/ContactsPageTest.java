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

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickContactsLink();		
	}
	
//	@Test(priority=1)
//	public void validateContactsLabelTest() {
//		Assert.assertTrue(contactsPage.validateContactsLabel(),"The contacts label is not visible !!");
//	}
//	
//	@Test(priority=2)
//	public void selectSingleContactByNameTest() throws InterruptedException {
//		contactsPage.selectContactByName("Test Test");
//	}
	
	@Test(priority=3)
	public void createNewContactTest() throws InterruptedException {
		homePage.clickOnNewContact();
		contactsPage.createNewContact("Mr.", "Rajesh", "Khanna", "Incedo");
		Thread.sleep(200000);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
