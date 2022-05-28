package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "strong.current-item")
    public WebElement currentItem;

    @FindBy(css = "button.button-2.email-a-friend-button")
    WebElement emailFriendBtn;

    @FindBy(id = "price-value-4")
    public WebElement productPriceLable;

    @FindBy(linkText = "Add your review")
    WebElement addReviewLink;

    @FindBy(id = "add-to-wishlist-button-4")
    WebElement wishlistBtn;

    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p/a")
    WebElement wishlistLink;

    public void OpenSendEmail(){
        OnClick(emailFriendBtn);
    }

    public void OpenReviewPage(){
        OnClick(addReviewLink);
    }

    public void AddProductToWishlist(){
        OnClick(wishlistBtn);
    }

    public void OpenWishlistPage(){
        OnClick(wishlistLink);
    }
}
