package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Home;
import pages.Mobile;

import java.util.concurrent.TimeUnit;

public class TestDayOne {
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
        Assert.assertTrue(home.getTitle().contains("THIS IS DEMO SITE FOR"));
        home.clickOnMobileLink();
        Thread.sleep(2000);
        Mobile mobile = new Mobile(this.driver);
        Assert.assertTrue(mobile.getTitle().equals("MOBILE"));
        mobile.setSelectorSortBy("Name");
        Thread.sleep(2000);
        Assert.assertTrue(mobile.getFirstProduct().equals("IPHONE"));
        Assert.assertTrue(mobile.getSecondProduct().contains("SAMSUNG"));
        Assert.assertTrue(mobile.getThirdProduct().contains("XPERIA"));
    }
    @AfterTest
    public void after(){
        driver.quit();
    }
}
