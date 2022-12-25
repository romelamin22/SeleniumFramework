package application.page_library;

import library.BaseSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SearchResultPage extends BaseSetup {

    @FindBy (xpath = "//main[@id='main']//h1/span")
    WebElement searchedTerm;

    @FindBy(xpath = "//div[@class='post-thumb']//a//img")
    WebElement prodcutFromSp;

    public SearchResultPage(){
        PageFactory.initElements(driver, this);
    }

    public String getSearchTerm(){

        return getTextInsideElement(searchedTerm);

    }

    public ProductPage clickOnProductFromSP(){

        prodcutFromSp.click();

        return new ProductPage();

    }




}
