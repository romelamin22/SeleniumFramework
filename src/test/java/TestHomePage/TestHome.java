package TestHomePage;

import application.page_library.HomePage;
import application.page_library.ProductPage;
import application.page_library.SearchResultPage;
import library.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.event.KeyEvent;

public class TestHome extends BaseSetup {

    /*
    *
    1. Open https://automation.scaledupit.com/

    2. Search for 'Shirt'

    3. Click on the product from search page

    4. Click on add to cart from the product page

    5. Navigate to the cart page from product page
    * */

    @Test
    public void testSearchFunction() throws InterruptedException {

        HomePage home = new HomePage();
        SearchResultPage resultPage = home.doSearch("shirt");
        resultPage.clickOnProductFromSP();
        Thread.sleep(3000);
        ProductPage productPage = new ProductPage();
        Thread.sleep(3000);
        productPage.clickOnAddToCart();
        Thread.sleep(3000);
        productPage.clickOnCart();
        Thread.sleep(3000);


        //Validating
        Assert.assertEquals(resultPage.getSearchTerm(), "shirt");

    }

    @Test
    public void sliderFunction(){

    }
    @Test
    public void menu(){

    }


}
