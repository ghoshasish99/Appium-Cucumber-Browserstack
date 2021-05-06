package pages;



import java.time.Duration;

import org.openqa.selenium.Point;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.Assert;

/**
 * Items page
 */
public class ItemsPage extends BasePage {

    /**
     * Product Top Bar
     */
    @AndroidFindBy(accessibility = "test-Cart drop zone")
    private MobileElement ProductsTopBar;
    
    /**
     * Add to cart button
     */
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]")
    private MobileElement AddToCart;

    /**
     * The cart icon
     */
    @AndroidFindBy(accessibility = "test-Cart")
    private MobileElement cartIcon;

    /**
     * The added item description
     */
    @AndroidFindBy(accessibility = "test-Description")
    private MobileElement itemDescription;
    
    /**
     * Checkout
     */
    @AndroidFindBy(accessibility = "test-CHECKOUT")
    private MobileElement Checkout;

    public ItemsPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }


    public void loginSuccessful() {
        Assert.assertTrue(ProductsTopBar.isDisplayed());
    }
    
    public void orderProduct(String ProductName) {
    	AddToCart.click();
    	cartIcon.click();
    	//Assert.assertTrue(itemDescription.getText().equals(ProductName));
    	String elementString = "CHECKOUT";
    	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+elementString+"\").instance(0))").click();

    }

}
