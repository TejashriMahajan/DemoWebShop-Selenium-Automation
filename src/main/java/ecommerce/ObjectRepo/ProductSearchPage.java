package ecommerce.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearchPage {
	
	WebDriver driver;

	public ProductSearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	
	@FindBy(id="small-searchterms")
	public WebElement searchBox;
	
	@FindBy(xpath="//input[@value=\"Search\"]")
	public WebElement searchButton;
	
	 @FindBy(css = ".product-item")
	    public WebElement productResult;
}
