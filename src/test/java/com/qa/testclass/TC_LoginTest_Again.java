package com.qa.testclass;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.ConfigPage.TestBase;
import com.qa.Pages.LoginPage;

public class TC_LoginTest_Again extends TestBase{
	
	
	
	@Test
	public void LoiginTestClass() throws InterruptedException {
		
		log.info("Login Application Was Open ");
		LoginPage lp = new LoginPage(driver);
		lp.getName(logusername);
		log.info("Enter UserName ");	
		lp.getPass(logpass);
		log.info("Enter Password");
		lp.clicklogin();
		log.info("Click on Login Button ");
		Thread.sleep(3000);
		if(isAlertpresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			log.warn("Test Was Fail");
		}
		else {
			Assert.assertTrue(true);
			lp.logoutbut();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
		
		
	}

	
}
