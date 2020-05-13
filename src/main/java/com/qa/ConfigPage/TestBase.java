package com.qa.ConfigPage;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.utilityFile.testUtilityFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	
	testUtilityFile tu = new testUtilityFile();
	public String baseurl = tu.getAplicationUrl();
	public String logusername = tu.getUserName();
	public String logpass = tu.getPassword();
	
	public static WebDriver driver;
//	public static WebDriverWait wait = new WebDriverWait(driver, testUtilityFile.Explicity_Wait);
	
	public static Logger log;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		
		log = Logger.getLogger("Invesment_Banking_Application");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") +"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
				
		}else if (br.equals("chrome")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") +"\\Drivers\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("The System Not able  to connect ");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(testUtilityFile.Implicity_TimeOut,TimeUnit.SECONDS);
		driver.get(baseurl);
	}
	
	@AfterClass
	public void tearDown() {
		
			driver.quit();
		
	}
	
	public boolean isAlertpresent() {
		try {

			driver.switchTo().alert();
			return true;
			
		} catch (NoAlertPresentException e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
	public void captureScree(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts =(TakesScreenshot)driver;
		File sorce = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/ScreenShot"+tname+".png");
		FileUtils.copyFile(sorce, target);
		System.out.println("Screenshot Taken ");
		
	}
	
}
