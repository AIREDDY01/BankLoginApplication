package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qa.utilityFile.testUtilityFile;

public class LoginPage {
	

	testUtilityFile tufile = new testUtilityFile();
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.NAME,using = "uid") @CacheLookup WebElement username ;
	@FindBy(how = How.NAME,using = "password") @CacheLookup WebElement password;
	@FindBy(how = How.NAME,using = "btnLogin")	@CacheLookup WebElement btnkclick;
	@FindBy(how = How.LINK_TEXT,using = "Log out") @CacheLookup WebElement logout;
	
	
	public void getName(String Stname) {
		username.sendKeys(Stname);
	}
	public void getPass(String Stpass) {
		password.sendKeys(Stpass);
	}
	public void clicklogin() {
		btnkclick.click();
	}
	
	public void logoutbut() {
		logout.click();
	}
}
