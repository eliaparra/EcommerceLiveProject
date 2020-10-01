package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class TestDayFive {
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
        Thread.sleep(1000);
        home.clickMyAccountlink();
        Thread.sleep(2000);
        Login login = new Login(this.driver);
        login.clickCreateAccountButton();
        Thread.sleep(2000);
        CreateAccount createAccount = new CreateAccount(this.driver);
        createAccount.enterFirstName("The");
        createAccount.enterMiddleName("QA");
        createAccount.enterLastName("corner");
        createAccount.enterEmail("theqacorner1+2@gmail.com");
        createAccount.enterPassword("pass123");
        createAccount.enterConfirmPassword("pass123");
        createAccount.clickRegister();
        Thread.sleep(2000);
        Account account = new Account(this.driver);
        Assert.assertTrue(account.getMessage().equals("Thank you for registering with Main Website Store."));
        account.clickOnTv();
        Thread.sleep(2000);
        Tv tv = new Tv(this.driver);
        tv.clickOnWishListLGLCD();
        Thread.sleep(2000);
        MyWishList myWishList = new MyWishList(this.driver);
        myWishList.clickWhislistButton();
        Thread.sleep(2000);
        ShareYourWishlist shareYourWishlist = new ShareYourWishlist(this.driver);
        shareYourWishlist.enterEmail("theqacorner1@gmail.com");
        shareYourWishlist.clickShareWishListButton();
        Thread.sleep(1000);
        Assert.assertTrue(myWishList.getMessage().equals("Your Wishlist has been shared."));

    }
    @AfterTest
    public void after(){
        driver.quit();
    }
}
