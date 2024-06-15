package pages;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Utils;

public class Loginpage {
	WebDriver driver;
	WebDriverWait wait;
Utils util;
	public Loginpage(WebDriver d) {
		this.driver=d;
		PageFactory.initElements(driver, this);
	
	}
	 	@FindBy(id="user-name") WebElement username;//using @FindBy identify element
		@FindBy(id="password") WebElement passwordd;
		@FindBy(id="login-button") WebElement btn;
		
		public String title() {
			String t=driver.getTitle();
			return t;
					
		}


		public void username(String usr,String pwd) {
			username.sendKeys(usr);
		
			passwordd.sendKeys(pwd);
				
		}		
		
		public Homepage click() {
			
			btn.click();	
			return new Homepage(driver);
		}
		
		//public void getcookie() {
			//Cookie cooki=new Cookie("Raj","123456789");
			//driver.manage().addCookie(cooki);
			//driver.manage().deleteCookie(cooki);
			//Set<Cookie> ck=driver.manage().getCookies();
			//for(Cookie c:ck) {
			//System.out.println(c);
		//}
//}

}
