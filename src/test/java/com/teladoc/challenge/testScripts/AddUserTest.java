package com.teladoc.challenge.testScripts;

import static org.testng.Assert.assertEquals;
import com.teladoc.BaseSetUp;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


//Scenario: Add a user and validate the user has been added to the table
public class AddUserTest 
{
    
	WebDriver driver;
	BaseSetUp baseClass = new BaseSetUp();
	By addButtonLoc = By.xpath("//button[@type='add']");
	By firstNameLoc = By.name("FirstName");
	By lastNameLoc = By.name("LastName");
	By userNameLoc = By.name("UserName");
	By roleLoc = By.name("RoleId");
	By emailLoc= By.name("Email");
	By phoneLoc = By.name("Mobilephone");
	By saveButtonLoc = By.xpath("//button[@class='btn btn-success']");

	
	//Launch browser and url
 	@BeforeMethod
 	@Parameters({"url"})
	public void openBrowser(String url)
	{
		baseClass.startBrowser(url);
		driver = baseClass.driver;
	}
	
 	//Test method to verify Delete User
	@Test
	@Parameters({"url","FirstName","LastName","UserName","Role","Email","Phone"})
  public void verifyAddUser(String url,String firstName,String lastName,String userName,String role,
		  	String email,String phone) throws InterruptedException {
		try
		{
		System.out.println("Filling User Details");
		//Click Add User
		driver.findElement(addButtonLoc).click();
		
		//Enter First Name
		driver.findElement(firstNameLoc).sendKeys(firstName);
		
		//Enter Last Name
		driver.findElement(lastNameLoc).sendKeys(lastName);
		
		//Enter User Name
		driver.findElement(userNameLoc).sendKeys(userName);
		
		//Select Role
		Select roleLocator = new Select(driver.findElement(roleLoc));
		roleLocator.selectByVisibleText(role);
		
		//Enter Email
		driver.findElement(emailLoc).sendKeys(email);
		
		//Enter Phone number
		driver.findElement(phoneLoc).sendKeys(phone);
		Thread.sleep(3000);
		//Click Save button
		driver.findElement(saveButtonLoc).click();
		
		//Refreshing the browser to verify that the user was actually added
		driver.navigate().refresh();
		
		//Find the list of users with given username
		List<WebElement> newUser= driver.findElements(By.xpath("//tr[td[position()=3 and text()='"+userName+"']]"));
		
		//Verify that the latest user is added and the number of items in the above list should be 1
		assertEquals(newUser.size(),1,"User Not Added");
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
  }
	
	//Tear down the browser
	@AfterMethod
	public void afterTest()
	{
		baseClass.afterTest();
	}

}
