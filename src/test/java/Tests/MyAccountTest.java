package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends TestBase{
    HomePage homeObject;
    UserRegistrationPage registerObject;
    MyAccountPage myAccountObject;
    LoginPage loginObject;

    String oldPassword = "123456789o";
    String newPassword = "123456";
    String firstName = "yara";
    String lastName = "emad";
    String email = "yaraaamira@gmail.com";


    @Test(priority = 1)
    public void UserRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new UserRegistrationPage(driver);
        registerObject.userRegistration(firstName,lastName,email,oldPassword);
        Assert.assertTrue(registerObject.SuccessMessage.getText().contains("Your registration completed"));
    }

    @Test(priority = 2)
    public void userChangePassword(){
        myAccountObject = new MyAccountPage(driver);
        registerObject.openMyAccountPage();
        myAccountObject.openChangePasswordPage();
        myAccountObject.ChangePassword(oldPassword,newPassword);
        Assert.assertTrue(myAccountObject.passwordChanged.getText().contains("Password was changed"));

    }

    @Test(priority = 3)
    public void UserLogoutSuccessfully(){
        registerObject.userLogout();
    }

    @Test(priority = 4)
    public void UserLoginAgain(){
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin(email,newPassword);
        Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));
    }

}
