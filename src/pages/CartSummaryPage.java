package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartSummaryPage extends BasicPage {

	public CartSummaryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement getClearAllButton()
	{
		return driver.findElement(By.partialLinkText("Clear All"));
	}
	
	public void ClearAllInCart() {
		getClearAllButton().click();
	}

}
