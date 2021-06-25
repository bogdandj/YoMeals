package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement getAuthIcon()
	{
		return driver.findElement(By.className("filled"));
	}
	
	public WebElement getMyAccountField()
	{
		return driver.findElement(By.partialLinkText("My Account"));
	}
	
	public WebElement getLogoutField()
	{
		return driver.findElement(By.partialLinkText("Logout"));
	}
	
	public void userLogout() {
		getAuthIcon().click();
		getLogoutField().click();
	}
}
