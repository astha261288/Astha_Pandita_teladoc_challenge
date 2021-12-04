package com.teladoc.challenge.testScripts;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.teladoc.BaseSetUp;


//Scenario: Delete user User Name: novak and validate user has been delete

public class DeleteUserTest {
	
	WebDriver driver;
	BaseSetUp baseClass= new BaseSetUp();
	By okButtonLoc = By.xpath("//div[@class='modal-footer']/button[2]");
	
	
	//Launch the browser and url
	@BeforeMethod
	@Parameters({"url"})
	public void openBrowser(String url)
	{
		baseClass.startBrowser(url);
		driver = baseClass.driver;
	}
	


	//Test method to verify Add user
  @Test
  @Parameters({"url","UserName"})
  public void deleteUser(String url, String userName) {
	  
	  try {
		  //Find the delete button for the given user	
		  System.out.println("Deleting the user");
		  WebElement delbutton = driver.findElement(By.xpath("//tr[td[position()=3 and text()='"+userName+"']]/td[11]/button"));
	  
		  //Click delete button for the given user
		  delbutton.click();
		  
		  //Find Ok button to confirm the deletion
		  WebElement okButton =driver.findElement(okButtonLoc);
		  
		  //Click Ok button in the modal
		  okButton.click();
		  
		  //Refershing the browser to verify that the user was actually deleted
		  driver.navigate().refresh();
	  
		  //Find the list users with given username
		  List<WebElement> deletedUser= driver.findElements(By.xpath("//tr[td[position()=3 and text()='"+userName+"']]"));
	 
		  //Verify that the delete user is deleted and the number of items in the above list should be 0
		  assertEquals(deletedUser.size(),0,"User Not Deleted");
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
