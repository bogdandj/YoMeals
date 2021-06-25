package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MealsPage extends BasicPage {

	public MealsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement getAddToFavoriteButton()
	{
		return driver.findElement(By.className("favourite"));
	}
	
	public WebElement getProduct()
	{
		return driver.findElement(By.xpath("//*[@class=product-list]/div"));
	}
	
	public WebElement getQuantity()
	{
		return driver.findElement(By.name("product_qty"));
	}
	
	public WebElement getSubmitButton()
	{
		return driver.findElement(By.className("btn--large"));
	}
	
	public void addQuantity(String qty) {
		
		getAddToFavoriteButton().click();
		getQuantity().sendKeys(Keys.DELETE);
		getQuantity().sendKeys(qty);
		getSubmitButton().click();
	}
	
	

}
