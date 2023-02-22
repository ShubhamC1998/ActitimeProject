package com.Actitime.Generic.library;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.POM.Homepage;
import com.Actitime.POM.Loginpage;

public class Baseclass {

	
FileLibrary f = new FileLibrary();
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("database connection",true);
	}
	
	@AfterSuite
	public void databasedisconnection() {
		Reporter.log("database disconnected",true);
	}
	
	@BeforeClass
	public void launchBrowser() throws IOException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://demo.actitime.com");
		String url = f.redDataFromPropertyFile("url");
		driver.get(url);
		Reporter.log("browser launch successfully",true);
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
		Reporter.log("browser closed successfully",true);
		
	}
	
	@BeforeMethod
	public void loginToActitime() throws IOException {
		String UN = f.redDataFromPropertyFile("username");
		String PW = f.redDataFromPropertyFile("password");
		Loginpage lp=new Loginpage(driver);
		lp.login(UN, PW);
		
		//driver.findElement(By.id("username")).sendKeys(UN);
		//driver.findElement(By.name("pwd")).sendKeys(PW);
		//driver.findElement(By.xpath("//div[.='Login ']")).click();
		Reporter.log("logged in successfully",true);
	}
	
	@AfterMethod
	public void logoutFromActitime() throws InterruptedException {
		Homepage hp=new Homepage(driver);
		Thread.sleep(5000);
		hp.getLgoutlnk().click();
		//driver.findElement(By.id("logoutLink")).click();
		Reporter.log("logged out successfully");
	}
	
	
	
}
