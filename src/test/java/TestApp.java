import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.io.IOException;

public class TestApp {

    protected static WebDriver driver;
    protected static LoginPage loginPage;
    protected static HomePage homePage;
    protected static BoutiquePage boutiquePage;
    protected static ProductPage productPage;

    @Before
    public void setUp() throws Exception {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        boutiquePage = new BoutiquePage(driver);
        productPage = new ProductPage(driver);
        loginPage.firefox();

    }

    @Test
    public void testApp() throws IOException, InterruptedException {
        loginPage.login();
        homePage.verifyPage();
        homePage.openBoutique();
        //this code line takes some time since it verifies all the images
        homePage.listOfImagesFailed();
        boutiquePage.openBrand();
        boutiquePage.waitForSeconds(2000);
        boutiquePage.openProduct();
        boutiquePage.waitForSeconds(2000);
        productPage.addToBasket();
    }

    @After
    public void tearDown(){
        loginPage.closePage();
    }

}
