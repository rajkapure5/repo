package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;

	public Homepage(WebDriver d) {
		this.driver=d;
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(id="add-to-cart-sauce-labs-backpack") WebElement addtocart;
		@FindBy(xpath="//div[@id='shopping_cart_container']/a") WebElement cart; 
		
	
public void addproduct() {
	addtocart.click();
	
}

public void clickcart() {
	cart.click();
	
}
}
