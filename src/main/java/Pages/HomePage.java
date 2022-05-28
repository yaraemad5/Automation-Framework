package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;

    @FindBy(id = "customerCurrency")
    WebElement currencyList;

    public void openRegistrationPage(){
        OnClick(registerLink);
    }

    public void openLoginPage(){
        OnClick(loginLink);
    }

    public void openContactUsPage(){
        scrollTo();
        OnClick(contactUsLink);
    }

    public void changeCurrency(){
        select = new Select(currencyList);
        select.selectByVisibleText("Euro");
    }
}
