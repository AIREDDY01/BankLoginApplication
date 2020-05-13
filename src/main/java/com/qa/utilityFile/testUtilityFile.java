package com.qa.utilityFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testUtilityFile {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties propcon;
	public static Properties propor;
	public static FileInputStream fis;
	public static FileOutputStream fos;
	
	public static long Page_Load_TimeOut = 10;
	public static long Implicity_TimeOut = 30;
	public static long Explicity_Wait =10;
	
	public testUtilityFile() {
		File source = new File(System.getProperty("user.dir")+"\\ConfigurFile\\Configur.properties");
		try {
			fis = new FileInputStream(source);
			propcon = new Properties();
			propcon.load(fis);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception is : " + e.getMessage());
		}
	}
	
	public String getAplicationUrl() {
		String url = propcon.getProperty("baseurl");
		return url;
	}
	public String getUserName() {
		String username = propcon.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password = propcon.getProperty("password");
		return password;
	}
	

	public String getChroPath() {
		String chrome = propcon.getProperty("chropath");
		return chrome;
	}
	public String getFirefox() {
		String firefox = propcon.getProperty("./Drivers/geckodriver.exe");
		return firefox;
	}
	
	public String getIE() {
		String ie = propcon.getProperty("iepath");
		return ie;
	}

	public void testUtilityFile() {
		
	File sourceor = new File("./ConfigurFile/OR.properties");
	try {
		fis = new FileInputStream(sourceor);
		propor = new Properties();
		propor.load(fis);
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Exception is : " + e.getMessage());
	}
}
	
	
	public String get_Locator_UserNamae() {
		String uname = propor.getProperty("unamelocator");
		return uname;
	}
	public String get_Locator_Password() {
		String upassword = propor.getProperty("psslocator");
		return upassword;
	}
	public String get_Locator_Click() {
		String uclick = propor.getProperty("btnlink");
		return uclick;
	}
	
}
