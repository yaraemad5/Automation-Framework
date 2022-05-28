package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Change password")
    WebElement changePasswordLink;

    @FindBy(id = "OldPassword")
    WebElement oldPasswordTxt;

    @FindBy(id = "NewPassword")
    WebElement newPasswordTxt;

    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmNewPasswordTxt;

    @FindBy(css = "button.button-1.change-password-button")
    WebElement changePasswordBtn;

    @FindBy(css = "p.content")
    public WebElement passwordChanged;

    @FindBy(css = "span.close")
    WebElement closeAlert;

    public void openChangePasswordPage(){
        OnClick(changePasswordLink);
    }

    public void ChangePassword(String oldpassword , String newpassword){
        sendText(oldPasswordTxt,oldpassword);
        sendText(newPasswordTxt,newpassword);
        sendText(confirmNewPasswordTxt,newpassword);
        OnClick(changePasswordBtn);
        OnClick(closeAlert);
    }
}
