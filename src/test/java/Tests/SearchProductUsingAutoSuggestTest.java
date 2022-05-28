package Tests;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductUsingAutoSuggestTest extends TestBase{
        SearchPage searchProductObject;
        ProductDetailsPage productObject;
        String searchItemTxt = "mac";
        String ProductName = "Apple MacBook Pro 13-inch";


        @Test
    public void UserUseAutoSuggest(){
                try {
                        searchProductObject = new SearchPage(driver);
                        productObject = new ProductDetailsPage(driver);
                        searchProductObject.ClickOnProductAutoSuggest(searchItemTxt);
                        Assert.assertEquals(productObject.currentItem.getText() , ProductName);

                }catch (Exception e){
                        System.out.println("Error Occurred...." + e.getMessage());
                }
            }
}
