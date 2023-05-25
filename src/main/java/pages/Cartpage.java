package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cartpage {
	WebDriver driver;	
	public Cartpage(WebDriver d) {
	this.driver=d;
	PageFactory.initElements(driver, this);
	}

	@FindBy(id="remove-sauce-labs-backpack") WebElement removeproduct;
	@FindBy(id="remove-remove-product") WebElement removeproduct1;
	@FindBy(id="continue-shopping") WebElement continueshopping;

	public void removep() {
		
		removeproduct.click();
		
	}

	public void continues() {
		
		continueshopping.click();
		
	}
}
