package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.thread.IThreadWorkerFactory;
import pages.*;

import java.util.concurrent.TimeUnit;

public class TestDayElevenTwo {
    private String PATHDRIVER = "./src/main/resources/";
    private  String url = "http://live.demoguru99.com/";
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
        driver.navigate().to("http://live.demoguru99.com/index.php/review/product/list/id/1/");
        Thread.sleep(2000);
        Review review = new Review(this.driver);
        review.enterReview("review example");
        review.enterSummary("summary text");
        review.enterNickname("my nickname");
        review.clickSubmitReview();
        Thread.sleep(1000);
        driver.navigate().to("http://live.demoguru99.com/index.php/backendlogin");
        Thread.sleep(2000);
        LoginBack loginBack = new LoginBack(this.driver);
        loginBack.loginBack();
        Thread.sleep(1000);
        CustomersBack customersBack = new CustomersBack(this.driver);
        customersBack.closeAlert();
        customersBack.clickCatalogLink();
        customersBack.clickReviewsandRatingsLink();
        customersBack.clickCustomerReviewsLink();
        customersBack.clickPendingReviewsLink();
        Thread.sleep(2000);
        PendingReviewsBack pendingReviewsBack = new PendingReviewsBack(this.driver);
        pendingReviewsBack.sortById();
        pendingReviewsBack.sortById();
        pendingReviewsBack.checkReview(0);
        pendingReviewsBack.clickEdit(0);
        Thread.sleep(2000);
        EditReview editReview = new EditReview(this.driver);
        editReview.setStatus("Approved");
        Thread.sleep(1000);
        editReview.clickSave();
        Thread.sleep(2000);
        driver.navigate().to("http://live.demoguru99.com/index.php/");
        Thread.sleep(1000);
        Home home = new Home(this.driver);
        home.clickOnMobileLink();
        Thread.sleep(1000);
        Mobile mobile = new Mobile(this.driver);
        mobile.clickOnXperia();
        mobile.clickOnReviewTab();
        Thread.sleep(5000);
        Assert.assertTrue(mobile.getReviewComment().contains("review example"));
    }
    @AfterTest
    public void after(){
        driver.quit();
    }
}
