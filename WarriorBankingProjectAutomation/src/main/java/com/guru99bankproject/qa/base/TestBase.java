package com.guru99bankproject.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase() {
		
		try {
		 prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\usrin\\eclipse-workspace\\WarriorBankingProjectAutomation\\src\\main\\java\\com\\"
					+ "guru99bankproject\\qa\\config\\config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver=new ChromeDriver();
		} else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	        driver = new FirefoxDriver();
		} else {
			System.out.println("None of the browsers identified");
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
}
