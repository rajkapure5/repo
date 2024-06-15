package test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class Listner implements ITestListener {
	ExtentSparkReporter htmlreoprt;
	ExtentReports extendrepor;
	ExtentTest test;
	WebDriver driver;
	
	
public void extendrepo() {
	htmlreoprt =new ExtentSparkReporter("C:\\Users\\Administrator\\eclipse-workspace\\latestpractice\\extendreport\\extendreport.html");
	extendrepor =new ExtentReports();
	extendrepor.attachReporter(htmlreoprt);
	 //set system information
	extendrepor.setSystemInfo("browser", "chrome");
	extendrepor.setSystemInfo("username", "raj kapure");
	
	//add configuration to change the look and feel of report
	htmlreoprt.config().setDocumentTitle("good extend report");
	htmlreoprt.config().setReportName("Extend Report");
	htmlreoprt.config().setTheme(Theme.DARK);
	
	
}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("test case is start"+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("test case is success"+result.getName());
		test =extendrepor.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("pass test name is "+result.getName(), ExtentColor.GREEN));
	}

	@Override
	
	public void onTestFailure(ITestResult result) {
	
		System.out.println("test case is failed"+result.getName());
		test =extendrepor.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("failed test name is "+result.getName(), ExtentColor.RED));
	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("test case is skipped"+result.getName());
		test =extendrepor.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("skipped test name is "+result.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("it will execute before test invoked");
		extendrepo();
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("it will execute after test invoked");
		extendrepor.flush();
	}

	

}
