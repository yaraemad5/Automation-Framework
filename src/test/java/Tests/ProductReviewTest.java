package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductReviewTest extends TestBase{

    HomePage homeObject;
    UserRegistrationPage registerObject;
    SearchPage searchProductObject;
    ProductDetailsPage productObject;
    ProductReviewPage reviewProductObject;
    String firstName = "yara";
    String lastName = "El-sayed";
    String email = "yara2998@gmail.com";
    String password = "123456789o";
    String searchItemTxt = "mac";
    String ProductName = "Apple MacBook Pro 13-inch";
    String reviewTitle = "macbook";
    String reviewTextMessage = "This macbook is very good and useful one! and with a very good price in the market";

    //1-user need first to register to the website to be able to add review to any product
    @Test(priority = 1)
    public void UserRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration(firstName,lastName,email,password);
        Assert.assertTrue(registerObject.SuccessMessage.getText().contains("Your registration completed"));
    }
    //2-user need to find element to add review message to it
    @Test(priority = 2)
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
    //3-user need to add review to the product
    @Test(priority = 3)
    public void UserCanAddReviewPage(){
        productObject = new ProductDetailsPage(driver);
        productObject.OpenReviewPage();
        reviewProductObject = new ProductReviewPage(driver);
        reviewProductObject.AddProductReview(reviewTitle,reviewTextMessage);
        Assert.assertTrue(reviewProductObject.successMessageReview
                .getText().contains("Product review is successfully added."));
    }
}
