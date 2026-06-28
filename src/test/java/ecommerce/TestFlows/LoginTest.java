package ecommerce.TestFlows;


import org.testng.annotations.Test;

import ecommerce.Base.CommonMethods;
import ecommerce.ObjectRepo.LoginPage;

public class LoginTest extends CommonMethods {

    @Test
    public void validLoginTest() {

        LoginPage loginpage = new LoginPage(driver);

        loginpage.Loginlink.click();
        loginpage.Email.sendKeys("your_registered_email@gmail.com");
        loginpage.Password.sendKeys("your_password");
        loginpage.Loginbutton.click();

       
    }
}
