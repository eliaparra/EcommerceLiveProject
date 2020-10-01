package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class TestDaySeven {
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
        account.clickOnMyOrders();
        Thread.sleep(1000);

        MyOrders myOrders = new MyOrders(this.driver);
        Assert.assertTrue(myOrders.getFirstOrder().equals("100013005"));
        Assert.assertTrue(myOrders.getStatusFirstOrder().equals("Pending"));
        myOrders.clickOnViewOrder();
        Thread.sleep(1500);

        OrderPage orderPage = new OrderPage(this.driver);
        orderPage.clickPrintOrder();

        Object[] allWindows = driver.getWindowHandles().toArray();
        driver.switchTo().window(allWindows[1].toString());
        Thread.sleep(2000);
        Assert.assertTrue(driver.getTitle().contains("Print Order"));
    }
    @AfterTest
    public void after(){
        driver.quit();
    }
}
