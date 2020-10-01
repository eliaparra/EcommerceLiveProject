package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Cart;
import pages.Home;
import pages.Mobile;
import pages.ProductPageMobile;

import java.util.concurrent.TimeUnit;

public class TestDayThree {
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
        home.clickOnMobileLink();
        Thread.sleep(2000);
        Mobile mobile = new Mobile(this.driver);
        mobile.clickOnAddToCartXperia();
        Thread.sleep(2000);
        Cart cart = new Cart(this.driver);
        cart.setQty(1000);
        Thread.sleep(100);
        cart.clickUpdateQty();
        Assert.assertTrue(cart.getErrorMsg().contains("The maximum quantity allowed for purchase is 500."));
        cart.clickEmptyCart();
        Thread.sleep(500);
        Assert.assertTrue(cart.getTitle().equals("SHOPPING CART IS EMPTY"));
    }
    @AfterTest
    public void after(){
        driver.quit();
    }
}
