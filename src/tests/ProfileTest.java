package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {

	@Test
	public void editProfile() throws IOException, InterruptedException {

		this.driver.get(baseUrl + "guest-user/login-form");

		Thread.sleep(1000);

		locationPopupPage.clickOnCloseButton();

		loginPage.loginAction(username, password);

		Assert.assertTrue(notificationSystemPage.getMessageString().contains("Login Successfull"),
				"[ERROR] Login isn't successfull");

		this.driver.navigate().to(baseUrl + "member/profile");

		profilePage.updateProfile("Bogdan", "Djuric", "blabla@haha.com", "Glavna 10", "064564565", "15000", "India",
				"Goa", "Raia");

		profilePage.uploadImage();
		Thread.sleep(1000);
		profilePage.getSaveButton().click();

		Thread.sleep(1000);
		Assert.assertTrue(notificationSystemPage.getMessageString().contains("Setup Successful" + ""),
				"[ERROR] Setup isn't successfull");

		authPage.userLogout();

		Assert.assertTrue(notificationSystemPage.getMessageString().contains("Logout Successfull"),
				"[ERROR] Logout isn't successfull");

	}

	@Test
	public void changeProfile() throws IOException {
		this.driver.navigate().to(baseUrl + "guest-user/login-form");
		locationPopupPage.clickOnCloseButton();
		loginPage.loginAction(username, password);

		Assert.assertTrue(notificationSystemPage.getMessageString().contains("Login Successfull"),
				"[ERROR] Login isn't successfull");

		this.driver.navigate().to(baseUrl + "member/profile");

		profilePage.uploadImage();

		Assert.assertTrue(notificationSystemPage.getMessageString().contains("Profile Image Uploaded Successfully"),
				"[ERROR] Profile image isn't uploaded successfully");
		notificationSystemPage.waitForElement();
		profilePage.removeImage();

		Assert.assertTrue(notificationSystemPage.getMessageString().contains("Profile Image Deleted Successfully"),
				"[ERROR] Profile image deleted successfully");

		notificationSystemPage.waitForElement();

		authPage.userLogout();

		Assert.assertTrue(notificationSystemPage.getMessageString().contains("Logout Successfull"),
				"[ERROR] Logout unsuccessful");
	}

}
