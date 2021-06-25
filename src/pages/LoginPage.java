package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getLoginButton()
	{
		return driver.findElement(By.className("filled"));
	}
	
	public WebElement getUsername() 
	{
		return driver.findElement(By.name("username"));
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(By.name("password"));
	}

	public WebElement getSubmitButton()
	{
		return driver.findElement(By.name("btn_submit"));
	}
	
	public void loginAction(String name, String password) {
		getLoginButton().click();
		getUsername().clear();
		getUsername().sendKeys(name);
		getPassword().clear();
		getPassword().sendKeys(password);
		getSubmitButton().click();
	}


}
