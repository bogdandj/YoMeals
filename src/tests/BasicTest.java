package tests;

import java.io.File;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealsPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;

public abstract class BasicTest {

	protected WebDriver driver;
	protected AuthPage authPage;
	protected CartSummaryPage cartSummaryPage;
	protected LocationPopupPage locationPopupPage;
	protected LoginPage loginPage;
	protected MealsPage mealsPage;
	protected NotificationSystemPage notificationSystemPage;
	protected ProfilePage profilePage;
	protected String baseUrl;
	protected String username;
	protected String password;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		baseUrl = "http://demo.yo-meals.com/";
		username = "customer@dummyid.com";
		password = "12345678a";

		authPage = new AuthPage(driver);
		cartSummaryPage = new CartSummaryPage(driver);
		locationPopupPage = new LocationPopupPage(driver);
		loginPage = new LoginPage(driver);
		mealsPage = new MealsPage(driver);
		notificationSystemPage = new NotificationSystemPage(driver);
		profilePage = new ProfilePage(driver);
	}

	@AfterMethod
	public void cleanup() {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File DestFile = new File("/YoMeals/screenshots");
		driver.close();

	}

}