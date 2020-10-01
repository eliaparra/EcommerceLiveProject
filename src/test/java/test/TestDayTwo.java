package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Home;
import pages.Mobile;
import pages.ProductPageMobile;

import java.util.concurrent.TimeUnit;

public class TestDayTwo {
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
        String priceMobile;
        String priceProductPage;
        driver.get(this.url);
        Home home = new Home(this.driver);
        home.clickOnMobileLink();
        Thread.sleep(2000);
        Mobile mobile = new Mobile(this.driver);
        priceMobile = mobile.getPrice();
        mobile.clickOnXperia();
        ProductPageMobile ppm = new ProductPageMobile(this.driver);
        priceProductPage = ppm.getPrice();
        Assert.assertTrue(priceMobile.equals(priceProductPage));
    }
    @AfterTest
    public void after(){
        driver.quit();
    }
}
