package stepdefinitions;

import java.util.concurrent.TimeUnit;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import pages.CheckoutPage;
import pages.ItemsPage;
import pages.LoginPage;
import io.appium.java_client.MobileElement;

public class steps {

	ItemsPage itemsPage;
	LoginPage loginPage;
	CheckoutPage checkoutPage;

	AndroidDriver<MobileElement> driver;

	@Given("^User launched SwagLabs application$")
	public void launchApp() {
		driver = DriverFactory.createAndroidDriverInstance();
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		loginPage = new LoginPage(driver);
		itemsPage = new ItemsPage(driver);
		checkoutPage = new CheckoutPage(driver);
	}

	@When("User logged in the app using username {string} and password {string}")
	public void user_logged_in_the_app_using_username_and_password(String username, String password) {
		loginPage.login(username, password);
	}

	@Then("^user should be able to log in$")
	public void logInSuccessful() {
		itemsPage.loginSuccessful();
	}

	@Then("^User should not get logged in$")
	public void logInFailed() {
		loginPage.loginFailed();
	}

	@When("User adds {string} product to the cart")
	public void user_adds_product_to_the_cart(String product) {
        itemsPage.orderProduct(product);
	}

	@When("User enters Checkout details with {string}, {string}, {string}")
	public void user_enters_Checkout_details_with(String FirstName, String LastName, String Zipcode) {
		checkoutPage.fillCheckoutDetails(FirstName, LastName, Zipcode);
	}
	
	@When("User completes Checkout process")
	public void user_completes_checkout_process() {
         checkoutPage.completeCheckout();
	}

	@Then("User should get the Confirmation of Order")
	public void user_should_get_the_Confirmation_of_Order() {
         checkoutPage.checkoutSuccessful();
	}


	@After
	public void tearDown(Scenario scenario) {
		if (driver != null) {
			driver.quit();
		}
	}
}