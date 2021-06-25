package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NotificationSystemPage extends BasicPage {

	public NotificationSystemPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement getMessageElement() {

		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success') "
				+ "or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	}

	public String getMessageString() {
		return getMessageElement().getText();
	}

	public void waitForElement() {
		wait.until(ExpectedConditions.presenceOfElementLocated(
				(By.xpath("//*[contains(@class, 'system_message')][contains(@style,'display: none')]"))));

	}
}