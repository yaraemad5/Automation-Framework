package Tests;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCurrencyTest extends TestBase{

    HomePage homeObject;
    SearchPage searchProductObject;
    ProductDetailsPage productObject;
    String searchItemTxt = "mac";
    String ProductName = "Apple MacBook Pro 13-inch";

    @Test(priority = 1)
    public void UserCanChangeCurrency(){
        homeObject = new HomePage(driver);
        homeObject.changeCurrency();

    }

    @Test(priority = 2)
    public void UserUseAutoSuggest(){
        try {
            searchProductObject = new SearchPage(driver);
            productObject = new ProductDetailsPage(driver);
            searchProductObject.ClickOnProductAutoSuggest(searchItemTxt);
            Assert.assertEquals(productObject.currentItem.getText() , ProductName);
            Assert.assertTrue(productObject.productPriceLable
                    .getText().contains("€"));
            System.out.println(productObject.productPriceLable.getText());
        }catch (Exception e){
            System.out.println("Error Occurred...." + e.getMessage());
        }
    }
}
