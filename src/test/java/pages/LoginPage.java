package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import junit.framework.Assert;

/**
 * Login page
 */
public class LoginPage extends BasePage {
	/**
	 * Home Page Icon
	 */
	@AndroidFindBy(accessibility = "test-Login")
	private MobileElement HomePageIcon;

	/**
	 * The login button
	 */
	@AndroidFindBy(accessibility = "test-LOGIN")
	private MobileElement loginButton;

	/**
	 * The user name input
	 */
	@AndroidFindBy(accessibility = "test-Username")
	private MobileElement usernameField;

	/**
	 * The password input
	 */
	@AndroidFindBy(accessibility = "test-Password")
	private MobileElement passwordField;

	/**
	 * Error Message
	 */
	@AndroidFindBy(accessibility = "test-Error message")
	private MobileElement errorMessage;

	/**
	 * Menu Icon
	 */
	@AndroidFindBy(accessibility = "test-Menu")
	private MobileElement menuIcon;

	/**
	 * Logout
	 */
	@AndroidFindBy(accessibility = "test-LOGOUT")
	private MobileElement Logout;

	public LoginPage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	public void login(String username, String password) {

		Assert.assertTrue(HomePageIcon.isDisplayed());
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();

	}

	public void loginFailed() {

		Assert.assertTrue(errorMessage.isDisplayed());

	}

	public void logout() {

		menuIcon.click();
		Logout.click();

	}

	public void logoutSuccessful() {
		Assert.assertTrue(HomePageIcon.isDisplayed());
	}

}
