package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase{

    public UserRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender-female")
    WebElement genderRadioBtn;

    @FindBy(id = "FirstName")
    WebElement FnTxtBox;

    @FindBy(id = "LastName")
    WebElement LnTxtBox;

    @FindBy(id = "Email")
    WebElement EmailTxtBox;

    @FindBy(id = "Password")
    WebElement PasswordTxtBox;

    @FindBy(id = "ConfirmPassword")
    WebElement ConfirmPasswordTxtBox;

    @FindBy(id = "register-button")
    WebElement RegisterBtn;

    @FindBy(css = "div.result")
   public WebElement SuccessMessage;

    @FindBy(css = "a.ico-logout")
    public WebElement LogoutLink;

    @FindBy(css = "a.ico-account")
    WebElement MyAccountLink;

    public void userRegistration(String firstName, String lastName, String email, String password){

        OnClick(genderRadioBtn);
        sendText(FnTxtBox,firstName);
        sendText(LnTxtBox,lastName);
        sendText(EmailTxtBox,email);
        sendText(PasswordTxtBox,password);
        sendText(ConfirmPasswordTxtBox,password);
        OnClick(RegisterBtn);

    }

    public void openMyAccountPage(){
        OnClick(MyAccountLink);
    }
    public void userLogout(){
        OnClick(LogoutLink);
    }
}
