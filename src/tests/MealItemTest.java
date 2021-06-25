package tests;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MealItemTest extends BasicTest {

	@Test
	public void mealTest() throws InterruptedException {
		this.driver.navigate().to(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");

		locationPopupPage.clickOnCloseButton();

		mealsPage.addQuantity("3");

		Assert.assertTrue(notificationSystemPage.getMessageString().contains("The Following Errors Occurred:"),
				"[ERROR] Location isn't chosen");

		Assert.assertTrue(notificationSystemPage.getMessageString().contains("Please Select Location"),
				"[ERROR] Location isn't chosen");

		notificationSystemPage.waitForElement();

		locationPopupPage.openLocationPopUp();

		locationPopupPage.setLocation("City Center - Albany");
		Thread.sleep(2000);
		mealsPage.addQuantity("3");

		Assert.assertTrue(notificationSystemPage.getMessageString().contains("Meal Added To Cart"),
				"[ERROR] Meal isn't added to cart");

	}

	@Test
	public void addMealToFavorite() {

		this.driver.navigate().to(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");

		locationPopupPage.clickOnCloseButton();

		mealsPage.getAddToFavoriteButton().click();

		Assert.assertTrue(notificationSystemPage.getMessageString().contains("Please login first!"),
				"[ERROR] Login isn't successful");

		this.driver.navigate().to(baseUrl + "guest-user/login-form");

		loginPage.loginAction(username, password);

		this.driver.navigate().to(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");

		mealsPage.getAddToFavoriteButton().click();
		Assert.assertTrue(
				notificationSystemPage.getMessageString().contains("Product has been added to your favorites."),
				"[ERROR] Product hasn't been added to you cart.");

	}

	@Test
	public void clearCartTest() throws IOException, InterruptedException {
		SoftAssert sa = new SoftAssert();

		driver.navigate().to(baseUrl + "meals");

		locationPopupPage.setLocation("City Center - Albany");

		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet("Meals");

		for (int i = 1; i < 6; ++i) {
			int quantity = (int) sheet.getRow(i).getCell(1).getNumericCellValue();
			String url = sheet.getRow(i).getCell(0).getStringCellValue();

			this.driver.navigate().to(url);
			String qty = String.valueOf(quantity);
			mealsPage.addQuantity(qty);

			sa.assertTrue(notificationSystemPage.getMessageString().contains("Meal Added To Cart"),
					"Login isn't successfull");

		}
		cartSummaryPage.ClearAllInCart();
		sa.assertTrue(notificationSystemPage.getMessageString().contains("All meals removed from Cart successfully"),
				"Login isn't successfull");
	}

}
