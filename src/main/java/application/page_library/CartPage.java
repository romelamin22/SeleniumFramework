package application.page_library;

import library.BaseSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseSetup {

    @FindBy(xpath = "//div[@class='wc-proceed-to-checkout']//a")
    WebElement pToCOut;

    public CartPage(){

        PageFactory.initElements(driver, this);

    }

    public void verifyPToCheckout(){

        pToCOut.isDisplayed();

    }






}
