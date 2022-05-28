package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    HomePage homeObject;
    LoginPage loginObject;

    @Test
    public void userLoginSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.openLoginPage();
        loginObject = new LoginPage(driver);
        loginObject.userLogin("yara19@gmail.com","123456789o");

    }
}
