package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "td.product")
    WebElement productName;

    @FindBy(css = "h1")
    WebElement pageHeader;

    @FindBy(css = "button.remove-btn")
    WebElement removeItemBtn;

    @FindBy(css = "div.no-data")
    public WebElement emptyCartMessage;

    public void removeProductFromWishlist(){
        OnClick(removeItemBtn);
    }
}
