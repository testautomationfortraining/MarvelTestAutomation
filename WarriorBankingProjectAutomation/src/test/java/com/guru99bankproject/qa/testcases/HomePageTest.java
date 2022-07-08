package com.guru99bankproject.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99bankproject.qa.base.TestBase;
import com.guru99bankproject.qa.pages.DeleteCustomerPage;
import com.guru99bankproject.qa.pages.HomePage;
import com.guru99bankproject.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	DeleteCustomerPage deleteCustomerPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("userId"), prop.getProperty("password"));
	}
	
	@Test(priority=0)
	public void validateHomePageTitle() {
		Assert.assertEquals(homePage.validateHomePageTitle(), "Guru99 Bank Manager HomePage");
	}
	
	@Test(priority=1)
	public void validateLogo() {
		Assert.assertTrue(homePage.validateHomePageLogo());
	}
	
	@Test(priority=2)
	public void navigateToDeleteCustomerPage() {
		deleteCustomerPage=homePage.clickDeleteCustomerBtn();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
