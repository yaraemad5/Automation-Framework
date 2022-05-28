package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegistrationTest extends TestBase{

    HomePage homeObject;
    UserRegistrationPage registerObject;
    LoginPage loginObject;
    @Test(priority = 1,alwaysRun = true)
    public void UserRegisterSuccessfully(){
            homeObject = new HomePage(driver);
            homeObject.openRegistrationPage();
            registerObject = new UserRegistrationPage(driver);
            registerObject.userRegistration("yara","El-sayed","yara2@gmail.com","123456789o");
        Assert.assertTrue(registerObject.SuccessMessage.getText().contains("Your registration completed"));
    }

    @Test(dependsOnMethods = "UserRegisterSuccessfully")
    public void UserLogoutSuccessfully(){
        registerObject.userLogout();
    }

    @Test(dependsOnMethods = "UserLogoutSuccessfully")
    public void UserLoginAgain(){
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin("yara2@gmail.com","123456789o");
        Assert.assertTrue(registerObject.LogoutLink.getText().contains("Log out"));
    }
}
