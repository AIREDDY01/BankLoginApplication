package com.qa.testclass;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.ConfigPage.TestBase;
import com.qa.Pages.LoginPage;

public class TC_LoginTest extends TestBase{
	
	
	@Test
	public void loginTest() throws InterruptedException {
		
		log.info("Get The URL of the Page");
		LoginPage lp = new LoginPage(driver);
	
		lp.getName(logusername);
		log.info("Enter UserName");
		lp.getPass(logpass);
		log.info("Enter Password");
		
		lp.clicklogin();
		log.info("Login Button Click");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			log.info("Login Test Pass");
		}
		else {
			Assert.assertFalse(false);
			log.info("Login Test Faile");
		}
		lp.logoutbut();
		
			
	}
	

}
