package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FullName")
    WebElement fullnameTtx;

    @FindBy(id = "Email")
    WebElement emailTxt;

    @FindBy(id = "Enquiry")
    WebElement enquiryTxt;

    @FindBy(name = "send-email")
    WebElement submitBtn;

    @FindBy(css = "div.result")
    public WebElement successMessage;

    public void ContactUs(String fullName , String email , String message){
            sendText(fullnameTtx,fullName);
            sendText(emailTxt,email);
            sendText(enquiryTxt,message);
            OnClick(submitBtn);

    }
}
