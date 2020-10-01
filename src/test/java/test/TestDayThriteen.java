package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CustomersBack;
import pages.InvoicesBack;
import pages.LoginBack;

import java.util.concurrent.TimeUnit;

public class TestDayThriteen {
    private String PATHDRIVER = "./src/main/resources/";
    private  String url = "http://live.demoguru99.com/index.php/backendlogin/";
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
        Thread.sleep(2000);

        CustomersBack customersBack = new CustomersBack(this.driver);
        customersBack.closeAlert();
        Thread.sleep(1000);
        customersBack.clickSalesLink();
        Thread.sleep(500);
        customersBack.clickInvoicesLink();
        Thread.sleep(2000);

        InvoicesBack invoicesBack = new InvoicesBack(this.driver);
        Thread.sleep(1000);
        invoicesBack.sortInvoiceDate();
        Thread.sleep(1000);
        invoicesBack.sortInvoiceDate();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/div[2]/div/table/tbody/tr[1]/td[3]")).getText().contains("Aug 21, 2020 10:05:01 AM"));
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/div[2]/div/table/tbody/tr[2]/td[3]")).getText().contains("Mar 6, 2020 5:56:50 PM"));
    }
    @AfterTest
    public void after(){
        driver.quit();
    }
}
