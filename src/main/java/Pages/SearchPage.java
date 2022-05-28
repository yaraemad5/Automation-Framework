package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;


public class SearchPage extends PageBase{
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "small-searchterms")
    WebElement searchBox;

    @FindBy(css = "button.button-1.search-box-button")
    WebElement searchBtn;

    @FindBy(id = "ui-id-1")
    List<WebElement> productList;

    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    WebElement productTitle;

    public void ProductSearch(String productName){
        sendText(searchBox,productName);
        OnClick(searchBtn);
    }

    public void OpenProductDetailsPage(){
        OnClick(productTitle);
    }

    public void ClickOnProductAutoSuggest(String searchTxt){
        sendText(searchBox,searchTxt);
        productList.get(0).click();
    }
}
