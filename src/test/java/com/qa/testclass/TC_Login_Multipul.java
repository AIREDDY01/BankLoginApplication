package com.qa.testclass;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.ConfigPage.TestBase;
import com.qa.Pages.LoginPage;
import com.qa.utilityFile.XLUtility;

public class TC_Login_Multipul extends TestBase{

	
	@Test(dataProvider = "dataname")
	public void multiLogin(String username,String Password) throws InterruptedException, IOException {
		
		log.info("Lanch The Login  Apllication ");
		LoginPage lp = new LoginPage(driver);
		lp.getName(username);
		lp.getPass(Password);
		lp.clicklogin();
		Thread.sleep(3000);
				
		if(isAlertpresent()==true) {
			String alertText = driver.switchTo().alert().getText();
			System.out.println("The Alert text is : "+ alertText);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			log.warn("Login Faile ");
		}
		else {
			
			Assert.assertTrue(true);
			log.info("Login Passed");
			lp.logoutbut();
			Thread.sleep(3000);
			String alertText = driver.switchTo().alert().getText();
			System.out.println("The Alert Text is : "+alertText);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();

			captureScree(driver, "LoginFile");
		}
		
		
		
	}
	
	@DataProvider(name = "dataname")
	public Object[][] getdata() throws IOException{
			
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\testdata\\testdatafile.xlsx";
		int rowcount = XLUtility.getRowCount(path, "Sheet1");
		int colcount = XLUtility.getCellCount(path, "Sheet1",1);
		Object[][] loginData = new Object[rowcount][colcount];
		for(int i =1;i<=rowcount;i++) {
			for(int j =0;j<colcount;j++) {
				loginData[i-1][j] = XLUtility.getCellData(path,"Sheet1",i,j); 
			}
		}
		return loginData;
			
	}
}
