package com.teladoc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseSetUp {
	
	public WebDriver driver;
	
	//Setting up the browser
	public void startBrowser(String url)
	{
			
		// TODO Auto-generated method stub
			System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
			try
			{
			driver = new FirefoxDriver();
			//driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			}
			
			catch (Exception e) {
				// TODO: handle exception
				System.out.println("Exception in BeforeMethod:" + e.toString());
			}
		
			
	}
	

	//Tearing down the browser
	public void afterTest()
	{
		driver.quit();
		
	}

}
