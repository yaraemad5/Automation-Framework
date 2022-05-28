package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
    protected WebDriver driver;
    public JavascriptExecutor js;
    public Select select;
    public Actions action;
     //create constructor
    public PageBase(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    protected static void OnClick(WebElement clickOn){
            clickOn.click();
    }

    protected static void sendText(WebElement textElement , String value){
            textElement.sendKeys(value);
    }

    public void scrollTo(){
        js.executeScript("scrollBy(0,2500)");
    }

}
