package ecommerce.TestFlows;

import org.testng.annotations.Test;

import ecommerce.Base.CommonMethods;
import ecommerce.ObjectRepo.CartPage;
import ecommerce.ObjectRepo.LoginPage;
import ecommerce.ObjectRepo.ProductPage;
import ecommerce.ObjectRepo.ProductSearchPage;

import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class CheckoutTest extends CommonMethods{
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 LoginPage loginPage;
	 ProductSearchPage searchPage;
	 ProductPage productPage;
	 CartPage cartPage;
	
	
  @Test
  
  public void CheckoutProduct() throws InterruptedException {

	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

      // Search product
      searchPage = new ProductSearchPage(driver);
      searchPage.searchBox.sendKeys("Laptop");
      searchPage.searchButton.click();
      Thread.sleep(2000);

      // Open product
      productPage = new ProductPage(driver);
      productPage.productLink.click();
      Thread.sleep(2000);

      // Add to cart
      productPage.addToCartButton.click();
      Thread.sleep(3000);

      // Open cart
      cartPage = new CartPage(driver);
      cartPage.shoppingCartLink.click();
      Thread.sleep(2000);

      // Accept terms and checkout
      cartPage.termsCheckbox.click();
      cartPage.checkoutButton.click();
      Thread.sleep(3000);

      //Select a billing Address
      Select select=new Select(cartPage.billingAddressdropdown);
      select.selectByValue("4633694");
      
      cartPage.billingContinueBtn.click();
      Thread.sleep(2000);	
      
   
   //Pickup in store
   wait.until(ExpectedConditions.elementToBeClickable(cartPage.pickupInStoreCheckbox)).click();
   wait.until(ExpectedConditions.elementToBeClickable(cartPage.shippingContinueBtn)).click();

   //payment method
   wait.until(ExpectedConditions.visibilityOf(cartPage.paymentMethodRadio));

   
   ((JavascriptExecutor) driver)
           .executeScript("arguments[0].click();", cartPage.paymentMethodRadio);

   wait.until(ExpectedConditions.elementToBeClickable(cartPage.paymentMethodContinueBtn)).click();

   // payment Info
   wait.until(ExpectedConditions.elementToBeClickable(cartPage.paymentInfoContinueBtn)).click();

   // order confirm
   wait.until(ExpectedConditions.elementToBeClickable(cartPage.confirmOrderBtn)).click();

   // verify order success
   wait.until(ExpectedConditions.visibilityOf(cartPage.orderSuccessMessage));

     Assert.assertTrue(
        cartPage.orderSuccessMessage.isDisplayed(),
        "Order was NOT placed successfully"
    );

  }

  @BeforeClass
  public void login() throws InterruptedException {
	  loginPage = new LoginPage(driver);
	  loginPage.Loginlink.click();
      Thread.sleep(2000);

      loginPage.Email.sendKeys("youremailid.com");
      loginPage.Password.sendKeys("yourpassword");
      loginPage.Loginbutton.click();
      Thread.sleep(3000);

  }

  @AfterClass
  public void logout() {
	  loginPage.logoutLink.click();
	  driver.quit();
  }

}

