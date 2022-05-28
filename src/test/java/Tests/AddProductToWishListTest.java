package Tests;


import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.WishListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToWishListTest extends TestBase{

    SearchPage searchProductObject;
    ProductDetailsPage productObject;
    WishListPage wishlistObject;
    String searchItemTxt = "mac";
    String ProductName = "Apple MacBook Pro 13-inch";

    //1-user first search on product
    @Test(priority = 1)
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

    //2-user add this product to wishlist
    @Test(priority = 2)
    public void UserAddProductToWishlist(){
        productObject = new ProductDetailsPage(driver);
        productObject.AddProductToWishlist();
        productObject.OpenWishlistPage();
    }

    //2-user remove this product from wishlist
    @Test(priority = 3)
    public void UserCanRemoveProductFromWishlist(){
        wishlistObject = new WishListPage(driver);
        wishlistObject.removeProductFromWishlist();
        Assert.assertTrue(wishlistObject.emptyCartMessage
                .getText().contains("The wishlist is empty!"));
    }

}
