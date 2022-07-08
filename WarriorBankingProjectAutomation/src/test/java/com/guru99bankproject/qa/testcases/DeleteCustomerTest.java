package com.guru99bankproject.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99bankproject.qa.base.TestBase;
import com.guru99bankproject.qa.pages.DeleteCustomerPage;
import com.guru99bankproject.qa.pages.HomePage;
import com.guru99bankproject.qa.pages.LoginPage;

public class DeleteCustomerTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	DeleteCustomerPage deleteCustomerPage;
	
	public DeleteCustomerTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("userId"), prop.getProperty("password"));
		deleteCustomerPage=homePage.clickDeleteCustomerBtn();
	}
	
	@Test(priority=0)
	public void validateTitle() {
		Assert.assertEquals(deleteCustomerPage.validateDeleteCustomerTitle(), "Guru99 Bank Delete Customer Page");
	}
	
	@Test(priority=1)
	public void deleteCustomer() {
		deleteCustomerPage.deleteCustomer(prop.getProperty("CustomerId"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
