package pages;

import java.io.File;

import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement getUserFirstName() {
		return driver.findElement(By.name("user_first_name"));
	}

	public WebElement getUserLastName() {
		return driver.findElement(By.name("user_last_name"));
	}

	public WebElement getUserEmail() {
		return driver.findElement(By.name("user_email"));
	}

	public WebElement getUserAddress() {
		return driver.findElement(By.name("user_address"));
	}

	public WebElement getUserPhone() {
		return driver.findElement(By.name("user_phone"));
	}

	public WebElement getUserZip() {
		return driver.findElement(By.name("user_zip"));
	}

	public WebElement getUserCountry() {
		return driver.findElement(By.name("user_country_id"));
	}

	public WebElement getUserState() {
		return driver.findElement(By.name("user_state_id"));
	}

	public WebElement getUserCity() {
		return driver.findElement(By.name("user_city"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.name("btn_submit"));
	}

	public WebElement getUploadButton() {
		return driver.findElement(By.className("upload"));
	}

	public WebElement getRemoveButton() {
		return driver.findElement(By.className("remove"));
	}

	public void uploadImage() throws IOException {
		js.executeScript("HTMLInputElement.prototype.click = function() {                     "
				+ "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  "
				+ "};                                                                  ");
		js.executeScript("arguments[0].click()", this.getUploadButton());
		String imgPath = new File("img\\Crna.png").getCanonicalPath();

		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(imgPath);
	}

	public void removeImage() {
		js.executeScript("arguments[0].click()", this.getRemoveButton());
	}

	public void updateProfile(String firstName, String lastName, String email, String address, String phone, String zip,
			String country, String state, String city) throws InterruptedException {

		getUserFirstName().clear();
		getUserFirstName().sendKeys(firstName);
		getUserLastName().clear();
		getUserLastName().sendKeys(lastName);
		getUserAddress().clear();
		getUserAddress().sendKeys(address);
		getUserPhone().clear();
		getUserPhone().sendKeys(phone);
		getUserZip().clear();
		getUserZip().sendKeys(zip);
		getUserCountry().sendKeys(country);
		Thread.sleep(500);
		getUserState().sendKeys(state);
		Thread.sleep(500);
		getUserCity().sendKeys(city);

	}
}
