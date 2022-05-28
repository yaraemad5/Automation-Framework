package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

    public ProductReviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "AddProductReview_Title")
    WebElement reviewTitleTxt;

    @FindBy(id = "AddProductReview_ReviewText")
    WebElement reviewTxt;

    @FindBy(id = "addproductrating_4")
    WebElement ratingBtn;

    @FindBy(name = "add-review")
    WebElement submitReviewBtn;

    @FindBy(css = "div.result")
    public WebElement successMessageReview;

    public void AddProductReview(String reviewTitle , String reviewText){
        sendText(reviewTitleTxt,reviewTitle);
        sendText(reviewTxt,reviewText);
        OnClick(ratingBtn);
        OnClick(submitReviewBtn);
    }
}
