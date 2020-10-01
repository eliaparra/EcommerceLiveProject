package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class TestDayNine {
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
        Thread.sleep(1500);

        Mobile mobile = new Mobile(this.driver);
        mobile.clickOnAddtoCartIPhone();
        Thread.sleep(2000);

        Cart cart = new Cart(this.driver);
        Float grandTotalPre = cart.getGrandTotal();
        cart.setCoupoCode("GURU50");
        cart.clickApplyCoupon();
        Thread.sleep(1500);
        Assert.assertTrue(grandTotalPre*0.05 == cart.getDiscount());
    }
    @AfterTest
    public void after(){
        driver.quit();
    }
}
