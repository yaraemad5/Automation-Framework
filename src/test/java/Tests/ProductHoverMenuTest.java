package Tests;

import Pages.ProductHoverMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductHoverMenuTest extends TestBase{

    ProductHoverMenuPage hoverMenuObject;

    @Test
    public void UserCanHoverOnAnyMenu(){
        hoverMenuObject = new ProductHoverMenuPage(driver);
        hoverMenuObject.selectNotebookMenu();
        Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
    }
}
