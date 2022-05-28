package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailFriendTest extends TestBase{

    HomePage homeObject;
    UserRegistrationPage registerObject;
    SearchPage searchProductObject;
    ProductDetailsPage productObject;
    EmailFriendPage emailObject;

    String firstName = "yara";
    String lastName = "El-sayed";
    String email = "yara29@gmail.com";
    String password = "123456789o";
    String searchItemTxt = "mac";
    String ProductName = "Apple MacBook Pro 13-inch";
    String friendEmail = "amira@gmail.com";
    String messageToFriend = "what is your opinion about this product!";

    //1-User must register first to be able to send email to friend
    @Test(priority = 1)
    public void UserRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration(firstName,lastName,email,password);
        Assert.assertTrue(registerObject.SuccessMessage.getText().contains("Your registration completed"));
    }

    //2-user need to search for product that he will send it to his friend
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

    //3-user here will send email to his friend
    @Test(priority = 3)
    public void UserSendEmailToFriend(){
        productObject.OpenSendEmail();
        emailObject = new EmailFriendPage(driver);
        emailObject.SendEmailToFriend(friendEmail,messageToFriend);
        Assert.assertTrue(emailObject.successMessage
                .getText().contains("Your message has been sent."));
    }
}
