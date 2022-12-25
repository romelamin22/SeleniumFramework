package application.page_library;

import library.BaseSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BaseSetup {

    @FindBy(xpath = "//button[@name='add-to-cart']")
    WebElement addToCart;

    @FindBy(xpath = "//i[@class='fa fa-shopping-cart']")
    WebElement viewCartButton;

    public ProductPage(){

        PageFactory.initElements(driver, this);

    }

    public void clickOnAddToCart(){

        addToCart.click();

    }

    public CartPage clickOnCart(){
        viewCartButton.click();

        return new CartPage();
    }


}
