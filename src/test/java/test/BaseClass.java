package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
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
	public void openBrowser() throws IOException {
		util=new Utils();
		System.setProperty("webdriver.chromedriver", "D:\\Important File\\newchromedriver\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
		    driver=new ChromeDriver(option);
			driver.get(util.getUrl());
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@AfterMethod
	public void closeBrowser() {
		
	}
}
