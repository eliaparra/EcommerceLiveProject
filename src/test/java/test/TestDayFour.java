package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Home;
import pages.Mobile;

import java.util.concurrent.TimeUnit;

public class TestDayFour {
    private String PATHDRIVER = "./src/main/resources/";
    private  String url = "http://live.demoguru99.com/index.php/";
    WebDriver driver;
    Object[] allWindows;

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
        mobile.addToCompareXperia();
        mobile.addToCompareIPhone();
        Thread.sleep(2000);
        mobile.clickOnCompareButton();
        Thread.sleep(2000);
        allWindows = driver.getWindowHandles().toArray();
        Assert.assertTrue(driver.switchTo().window(allWindows[1].toString()).findElement(By.tagName("h1")).getText().equals("COMPARE PRODUCTS"));
        Assert.assertTrue(driver.switchTo().window(allWindows[1].toString()).findElement(By.xpath("//*[@id='product_comparison']/tbody[1]/tr[1]/td[1]/h2/a")).getText().contains("SONY XPERIA"));
        Assert.assertTrue(driver.switchTo().window(allWindows[1].toString()).findElement(By.xpath("//*[@id='product_comparison']/tbody[1]/tr[1]/td[2]/h2/a")).getText().contains("IPHONE"));

    }
    @AfterTest
    public void after(){
        driver.quit();
    }
}
