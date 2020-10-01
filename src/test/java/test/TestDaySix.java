package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class TestDaySix {
    private String PATHDRIVER = "./src/main/resources/";
    private  String url = "http://live.demoguru99.com/index.php/";
    WebDriver driver;


    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.gecko.driver",PATHDRIVER+"geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void runTest() throws InterruptedException {
        driver.get(this.url);
        Home home = new Home(this.driver);
        home.clickAccountButton();
        Thread.sleep(500);
        home.clickLogInLink();
        Thread.sleep(2000);

        Login login = new Login(this.driver);
        login.enterEmail("theqacorner1+2@gmail.com");
        login.enterPassword("pass123");
        login.clickLogin();

        Thread.sleep(2000);
        Account account = new Account(this.driver);
        account.clickOnMyWishlist();
        Thread.sleep(1000);

        MyWishList myWishList = new MyWishList(this.driver);
        Thread.sleep(2000);
        myWishList.clickAddToCart();
        Thread.sleep(2000);

        Cart cart = new Cart(this.driver);
        cart.setCountry("United States");
        cart.setRegion("New York");
        cart.enterZip(542896);
        cart.clickOnEstimate();
        Thread.sleep(1500);
        cart.clickRateRadio();
        Thread.sleep(500);
        Assert.assertTrue(cart.getShippingCost() == 5.00);
        cart.clickUpdateTotal();
        Thread.sleep(2000);
        Float subtotal = cart.getSubtotal();
        Float shippingCost = cart.getShippingCost();
        Float grandTotal = cart.getGrandTotal();
        Assert.assertTrue(subtotal+shippingCost==grandTotal);
        cart.clickProceedToCheckout();
        Thread.sleep(2000);

        Checkout checkout = new Checkout(this.driver);
        checkout.enterFirstName("theQA");
        checkout.enterlastName("Corner");
        checkout.enterAddress("nombre calle");
        checkout.enterCity("New York");
        checkout.setRegion("New York");
        checkout.enterZip("123564");
        checkout.enterTelephone("123456789");
        Thread.sleep(500);
        checkout.clickcontinueButtonBillingInformation();
        Thread.sleep(1000);
        checkout.clickcontinueButtonShippingmethod();
        Thread.sleep(1000);
        checkout.selectMoney();
        checkout.clickcontinuePaymentInformation();
        Thread.sleep(1000);
        checkout.clickplaceOrder();
        Thread.sleep(5000);

        ThankYouPage typ = new ThankYouPage(this.driver);
        Assert.assertFalse(typ.getMessage().isEmpty());
        Assert.assertFalse(typ.getOrderNumber().isEmpty());
    }
    @AfterTest
    public void after(){
        driver.quit();
    }
}
