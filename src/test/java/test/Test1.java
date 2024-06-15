package test;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import pages.Cartpage;
import pages.Homepage;
import pages.Loginpage;
import utility.Utils;

public class Test1 extends BaseClass {
	public Loginpage login;
	public Homepage homepage;
	public Cartpage cr;
	public Utils util;
	@Test(priority=1)
	public void loginPage() throws IOException, InterruptedException {
		 util=new Utils();
		 	login=new Loginpage(driver);
		 			login.title();
		 			Thread.sleep(5000);
		 			login.username(util.getUsername(),util.getPassword());
		 					Homepage homepage=login.click();
		 						//login.getcookie();
		 						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		 						
		 						Assert.assertEquals(util.verifylogin(), homepage.very());
	
}
	@Test(priority=2)
	public void cart() throws InterruptedException {
		login=new Loginpage(driver);
		login.username(util.getUsername(), util.getPassword());
		Homepage homepage=login.click();
	Thread.sleep(5000);
	homepage.addproduct();
	Cartpage cr=homepage.clickcart();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	cr.removep();
	cr.continues();
	Thread.sleep(5000);
	Assert.assertTrue(false);
	
	}
	@Test(priority=3)
	public void skip() {
		System.out.println("skip method");
		throw new SkipException("Skipped method succesfully");
	}
	@AfterMethod
		public void  screen(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			TakesScreenshot	screen1=((TakesScreenshot)driver);
			File  get = screen1.getScreenshotAs(OutputType.FILE);
			Files.copy(get, new File("C:\\Users\\Administrator\\eclipse-workspace\\latestpractice\\screenshot\\screenshot1.jpg"));
	
	
			}
	
		}
	
	
}
