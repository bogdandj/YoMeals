package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasicPage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	

	public BasicPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		js = (JavascriptExecutor) driver;
	}
}