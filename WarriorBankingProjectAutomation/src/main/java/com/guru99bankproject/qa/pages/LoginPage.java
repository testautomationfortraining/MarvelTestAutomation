package com.guru99bankproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99bankproject.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//writing xpaths
	@FindBy(xpath="//input[@name='uid']")
	WebElement userId;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement btnLogin;
	
	@FindBy(xpath="//h2[text()='Guru99 Bank']")
	WebElement logo;
	
	//initialize the method
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//action methods
	public String validateLoginTitle() {
		return driver.getTitle();
	}

	public boolean validateLoginPageLogo() {
		return logo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) {
		userId.sendKeys(un);
		password.sendKeys(pwd);
		btnLogin.click();
		return new HomePage();
	}
}
