package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage extends BasicPage{

	public LocationPopupPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement getLocation() {
		return driver.findElement(By.className("location-selector"));
	}
	
	public WebElement getCloseButton() {
		return driver.findElement(By.className("close-btn"));
	}

	public WebElement getKeyword()
	{
		return driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}
	
	public WebElement getLocationItem(String locationName)
	{
		return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}
	
	public WebElement getLocationInput()
	{
		return driver.findElement(By.xpath("//*[@id='location_id']"));
	}
	
	public WebElement getSubmit()
	{
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}
	
	public void openLocationPopUp()
	{
		getLocation().click();
	}
	
	public void clickOnCloseButton() {
		js.executeScript("arguments[0].click()", this.getCloseButton());
	}
	
	public void setLocation(String locationName) {
		getKeyword().click();
		String value = getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value=arguments[1]", getLocationInput(), value);
		js.executeScript("arguments[0].click()", getSubmit());
		getSubmit().click();
	}
	
}


