package test;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.Homepage;
import pages.Loginpage;
import utility.Utils;

public class BaseClass {
	public Utils util;
	public WebDriver driver;
	public Homepage homepage;
	public Loginpage login;
	@BeforeMethod
	public void openBrowser() {
		try {
			util=new Utils();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setProperty("webdriver.chromedriver","D:\\Important File\\newchromedriverfile\\chrome-win64\\chrome-win64\\chromedriver.exe");
			
		    driver=new ChromeDriver();
		    driver.manage().window().maximize();
			driver.get(util.getUrl());
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
