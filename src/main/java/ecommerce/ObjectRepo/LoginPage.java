package ecommerce.ObjectRepo;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class LoginPage {
//	WebDriver driver;
//	
//	public LoginPage(WebDriver driver)
//	{
//		this.driver=driver;
//		PageFactory.initElements(driver,this);
//	}
//	
//	@FindBy(xpath="//a[normalize-space()='Log in']")
//	public WebElement Loginlink;
//	
//	@FindBy(id="Email")
//	public WebElement Email;
//	
//	@FindBy(id="Password")
//	public WebElement Password;
//	
//	@FindBy(xpath="//input[@value='Log in']")
//	public WebElement Loginbutton;
//	
//	@FindBy(xpath="//a[normalize-space()='Log out']")
//	public WebElement logoutLink;
//	
//	
//	
//}

public class LoginPage{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy("")
	public WebElement login;
	
}