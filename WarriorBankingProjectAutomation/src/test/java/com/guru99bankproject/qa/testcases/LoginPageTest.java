package com.guru99bankproject.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99bankproject.qa.base.TestBase;
import com.guru99bankproject.qa.pages.HomePage;
import com.guru99bankproject.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
	}
	
	@Test(priority=0)
	public void validateTitle() {
		Assert.assertEquals(loginPage.validateLoginTitle(), "Guru99 Bank Home Page");
	}
	
	@Test(priority=1)
	public void validateLogo() {
		Assert.assertTrue(loginPage.validateLoginPageLogo());
	}
	
	@Test(priority=2)
	public void loginToApp() {
		homePage=loginPage.login(prop.getProperty("userId"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
