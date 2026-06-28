package ecommerce.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CartPage {
	 WebDriver driver;

	    public CartPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }


	    @FindBy(linkText = "Shopping cart")
	    public WebElement shoppingCartLink;

	    @FindBy(id = "termsofservice")
	    public WebElement termsCheckbox;

	    @FindBy(id = "checkout")
	    public WebElement checkoutButton;

	    // Billing Address
	    @FindBy(id = "BillingNewAddress_CountryId")
	    public WebElement countryDropdown;

	    @FindBy(id = "BillingNewAddress_StateProvinceId")
	    public WebElement stateDropdown;

	    @FindBy(id = "BillingNewAddress_ZipPostalCode")
	    public WebElement zipCode;

	    @FindBy(xpath = "//input[@onclick='Billing.save()']")
	    public WebElement billingContinueBtn;
	    
	    @FindBy(xpath="(//select[@id='billing-address-select'])[1]")
	    public WebElement billingAddressdropdown;
	    
	    @FindBy(xpath="(//option[@value='4633694'])[1]")
	    public WebElement selectAddress;
	    
	    @FindBy(xpath="//input[@onclick=\"Billing.save()\"]")
	    public WebElement billingCntbtn;

	   
	    @FindBy(xpath = "//input[@id='PickUpInStore']")
        public WebElement pickupInStoreCheckbox;

        @FindBy(xpath = "//input[@onclick='Shipping.save()']")
	    public WebElement shippingContinueBtn;

	    // Shipping Method
        @FindBy(xpath = "//input[@onclick='ShippingMethod.save()']")
	    public WebElement shippingMethodContinueBtn;
   
         
        // Payment Method
        @FindBy(id = "paymentmethod_0")
        public WebElement paymentMethodRadio;

        @FindBy(xpath = "//input[@class='button-1 payment-method-next-step-button']")
        public WebElement paymentMethodContinueBtn;

        // Payment Information
        @FindBy(xpath = "//input[@class='button-1 payment-info-next-step-button']")
        public WebElement paymentInfoContinueBtn;

        // Confirm
	    @FindBy(xpath = "//input[@value='Confirm']")
        public WebElement confirmOrderBtn;

       // Success message
	    @FindBy(xpath = "//strong[contains(text(),'Your order has been successfully processed!')]")
	    public WebElement orderSuccessMessage;


}
