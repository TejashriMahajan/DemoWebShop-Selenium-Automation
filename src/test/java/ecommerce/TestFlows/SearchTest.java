package ecommerce.TestFlows;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ecommerce.Base.CommonMethods;
import ecommerce.ObjectRepo.LoginPage;
import ecommerce.ObjectRepo.ProductSearchPage;
import ecommerceUtility.ExcelUtils;

public class SearchTest extends CommonMethods {

    LoginPage loginPage;
    ProductSearchPage searchPage;

    @BeforeClass
    public void login() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.Loginlink.click();
        Thread.sleep(2000);
        loginPage.Email.sendKeys("tejchaudhari15@gmail.com");
        loginPage.Password.sendKeys("H@rsh123");
        Thread.sleep(2000);
        loginPage.Loginbutton.click();
    }

    @Test(dataProvider = "SearchData")
    public void searchProductTest(String productName) throws InterruptedException {

        searchPage = new ProductSearchPage(driver);
        searchPage.searchBox.clear();
        searchPage.searchBox.sendKeys(productName);
        Thread.sleep(2000);
        searchPage.searchButton.click();
        Thread.sleep(2000);
    }

    @AfterClass
    public void logout() {
        loginPage.logoutLink.click();
    }

    @DataProvider(name = "SearchData")
    public Object[][] getSearchData() throws IOException {

        String excelPath = System.getProperty("user.dir")
                + "/src/main/resources/testdata/SearchData.xlsx";

        return ExcelUtils.getExcelData(excelPath, "SearchData");
    }

}
