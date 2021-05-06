package pages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import junit.framework.Assert;

/**
 * Checkout page
 */
public class CheckoutPage extends BasePage {

    /**
     * First Name
     */
    @AndroidFindBy(accessibility = "test-First Name")
    private MobileElement FirstName;
    
    /**
     * Last Name
     */
    @AndroidFindBy(accessibility = "test-Last Name")
    private MobileElement LastName;

    /**
     * Postal Code
     */
    @AndroidFindBy(accessibility = "test-Zip/Postal Code")
    private MobileElement PostalCode;

    /**
     * Continue Button
     */
    @AndroidFindBy(accessibility = "test-CONTINUE")
    private MobileElement Continue;
    
    /**
     * Finish Button
     */
    @AndroidFindBy(accessibility = "test-FINISH")
    private MobileElement Finish;
    
    /**
     * Success Message
     */
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]")
    private MobileElement successMessage;

    
    public CheckoutPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

 
    public void fillCheckoutDetails(String firstname, String lastname, String postcode) {
        
    	FirstName.sendKeys(firstname);
    	LastName.sendKeys(lastname);
    	PostalCode.sendKeys(postcode);
    
    }
    
    public void completeCheckout() {
    	String continueButtonString = "CONTINUE";
    	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+continueButtonString+"\").instance(0))").click();

    	String finishButtonString = "FINISH";
    	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+finishButtonString+"\").instance(0))").click();

    }

    public void checkoutSuccessful() {
        Assert.assertTrue(successMessage.isDisplayed());
    }
}
