package test;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CustomersBack;
import pages.LoginBack;
import pages.OrdersBack;

import java.util.concurrent.TimeUnit;

public class TestDayElevenOne {
    private String PATHDRIVER = "./src/main/resources/";
    private  String url = "http://live.demoguru99.com/index.php/backendlogin/";
    WebDriver driver;



    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.gecko.driver",PATHDRIVER+"geckodriver.exe");
        FirefoxOptions  options = new FirefoxOptions();
        options.setCapability("browser.download.folderList", 2);
        options.setCapability("browser.download.dir", "C:/Users/Elia/Downloads");
        options.setCapability("browser.download.useDownloadDir", true);
        options.setCapability("browser.helperApps.neverAsk.saveToDisk", "application/pdf");


        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void runTest() throws InterruptedException {
        driver.get(this.url);
        LoginBack loginBack = new LoginBack(this.driver);
        loginBack.loginBack();
        Thread.sleep(2000);

        CustomersBack customersBack = new CustomersBack(this.driver);
        customersBack.closeAlert();
        Thread.sleep(1000);
        customersBack.clickSalesLink();
        Thread.sleep(500);
        customersBack.clickOrdersLink();
        Thread.sleep(2000);

        OrdersBack ordersBack = new OrdersBack(this.driver);
        ordersBack.setStatus("Canceled");
        Thread.sleep(500);
        ordersBack.clickSearch();
        Thread.sleep(2000);
        ordersBack.clickCheckBox(0);
        Thread.sleep(2000);
        ordersBack.setActions("Print Invoices");
        ordersBack.clickSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(ordersBack.getMessage().contains("There are no printable documents related to selected orders."));
        Thread.sleep(1000);
        ordersBack.setStatus("Complete");
        Thread.sleep(500);
        ordersBack.clickSearch();
        Thread.sleep(2000);
        ordersBack.clickCheckBox(0);
        ordersBack.setActions("Print Invoices");
        ordersBack.clickSubmit();
        Thread.sleep(5000);
        Assert.assertTrue(ordersBack.isFileDownloaded("C:/Users/Elia/Downloads","invoice2020"));
    }
    @AfterTest
    public void after(){
        driver.quit();
    }
}
