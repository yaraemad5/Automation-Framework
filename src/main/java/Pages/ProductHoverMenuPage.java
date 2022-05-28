package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductHoverMenuPage extends PageBase{

    public ProductHoverMenuPage(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
    }
    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
    WebElement computerMenu;

    //xpath by me //a[@href='/computers'][preceding::ul[@class='top-menu notmobile']]
    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
    WebElement notebookMenu;

    public void selectNotebookMenu(){
        action.moveToElement(computerMenu)
                .moveToElement(notebookMenu)
                .click()
                .build()
                .perform();
    }
}
