package test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
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
		 						login.click();
		 						login.getcookie();
		 						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		
	
}
	@Test(priority=2)
	public void cart() throws InterruptedException {
		login=new Loginpage(driver);
	 	homepage=new Homepage(driver);
		cr=new Cartpage(driver);
		login.username(util.getUsername(), util.getPassword());
		login.click();
	Thread.sleep(5000);
	homepage.addproduct();
	homepage.clickcart();
	Thread.sleep(10000);
	cr.removep();
	cr.continues();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	Assert.assertTrue(false);
	
	}
	@AfterMethod
		public void screen(ITestResult result) throws IOException {
			if(result.getStatus()==ITestResult.FAILURE) {
				TakesScreenshot	screen1=((TakesScreenshot)driver);
				File get = screen1.getScreenshotAs(OutputType.FILE);
					Files.copy(get, new File("C:\\Users\\Administrator\\eclipse-workspace\\latestpractice\\screenshot\\screenshot1.jpg"));
	}
	}
}
