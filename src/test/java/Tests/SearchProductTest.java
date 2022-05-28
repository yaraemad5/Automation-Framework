package Tests;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTest extends TestBase{
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    String productName = "Apple MacBook Pro 13-inch";

    @Test
    public void UserSearchForProduct(){
        searchObject = new SearchPage(driver);
        productDetailsObject = new ProductDetailsPage(driver);
        searchObject.ProductSearch(productName);
        searchObject.OpenProductDetailsPage();
        Assert.assertTrue(productDetailsObject
                .currentItem.getText().equalsIgnoreCase(productName));
        //Assert.assertEquals(productDetailsObject.currentItem.getText(),productName);
    }
}
