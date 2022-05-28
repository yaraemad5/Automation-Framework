package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{

    public EmailFriendPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FriendEmail")
    WebElement friendEmailTxt;

    @FindBy(id = "PersonalMessage")
    WebElement personalMessageTxt;

    @FindBy(name = "send-email")
    WebElement sendEmailBtn;

    @FindBy(css = "div.result")
    public WebElement successMessage;

    public void SendEmailToFriend(String friendEmail , String personalMessage){
        sendText(friendEmailTxt,friendEmail);
        sendText(personalMessageTxt,personalMessage);
        OnClick(sendEmailBtn);
    }
}
