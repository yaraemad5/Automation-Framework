package Tests;

import Pages.ContactUsPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends TestBase{
        ContactUsPage contactUsObject;
        HomePage homeObject;

        String fullName = "Tester";
        String email = "tester@gmail.com";
        String message = "welcome dear tester in out website";

        @Test
    public void UserContactUsTest(){
            contactUsObject = new ContactUsPage(driver);
            homeObject = new HomePage(driver);
            homeObject.openContactUsPage();
            contactUsObject.ContactUs(fullName,email,message);
            Assert.assertTrue(contactUsObject.successMessage
                    .getText().contains("Your enquiry has been successfully sent to the store owner."));
        }
}
