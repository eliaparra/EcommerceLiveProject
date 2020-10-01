package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class TestDayEight {
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
        Thread.sleep(1500);
        home.clickMyAccountlink();
        Thread.sleep(1500);

        Login login = new Login(this.driver);
        login.enterEmail("theqacorner1+2@gmail.com");
        login.enterPassword("pass123");
        login.clickLogin();
        Thread.sleep(1500);

        Account account = new Account(this.driver);
        account.clickOnReorder();
        Thread.sleep(1000);

        Cart cart = new Cart(this.driver);
        Float grandTotalPre = cart.getGrandTotal();
        cart.setQty(10);
        cart.clickUpdateQty();
        Thread.sleep(500);
        Assert.assertTrue(grandTotalPre!= cart.getGrandTotal());
        cart.clickProceedToCheckout();
        Thread.sleep(2000);

        Checkout checkout = new Checkout(this.driver);
        checkout.clickcontinueButtonBillingInformation();
        Thread.sleep(1000);
        checkout.clickcontinueButtonShippingmethod();
        checkout.selectMoney();
        checkout.clickcontinuePaymentInformation();
        Thread.sleep(500);
        checkout.clickplaceOrder();
        Thread.sleep(2000);

        ThankYouPage typ = new ThankYouPage(this.driver);
        Assert.assertFalse(typ.getOrderNumber().isEmpty());
    }
    @AfterTest
    public void after(){
        driver.quit();
    }
}
