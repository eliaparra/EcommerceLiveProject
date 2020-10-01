package test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class TestDayFifteen {
    private String PATHDRIVER = "./src/main/resources/";
    private  String url = "http://live.demoguru99.com/index.php/backendlogin";
    WebDriver driver;



    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.gecko.driver",PATHDRIVER+"geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
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
        Thread.sleep(1000);

        CustomersBack customersBack = new CustomersBack(this.driver);
        customersBack.closeAlert();
        customersBack.clickCustomersLink();
        customersBack.clickmanageCustomersLink();
        Thread.sleep(1000);

        ManageCustomers manageCustomers = new ManageCustomers(this.driver);
        manageCustomers.clickFirstEdit();
        Thread.sleep(1000);

        CustomerInformation customerInformation = new CustomerInformation(this.driver);
        customerInformation.clickAccountInformation();
        Thread.sleep(1000);
        Assert.assertFalse(customerInformation.checkWebSiteAssociated());
        Assert.assertFalse(customerInformation.checkCreatedFrom());
        Assert.assertTrue(customerInformation.checkNewPassword());
    }
    @AfterTest
    public void after(){
        driver.quit();
    }
}
