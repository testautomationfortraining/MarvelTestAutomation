package com.guru99bankproject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99bankproject.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[text()='Delete Customer']")
	WebElement deleteCustomerBtn;

	@FindBy(xpath = "//h2[text()='Guru99 Bank']")
	WebElement logo;

	@FindBy(xpath = "//a[text()='Log out']")
	WebElement logoutBtn;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//actions methods
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateHomePageLogo() {
		return logo.isDisplayed();
	}
	
	public void logout() {
		logoutBtn.click();
	}
	
	public DeleteCustomerPage clickDeleteCustomerBtn() {
		deleteCustomerBtn.click();
		return new DeleteCustomerPage();
	}

}
