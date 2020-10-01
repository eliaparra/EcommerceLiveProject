package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class TestDayFourteen {
    private String PATHDRIVER = "./src/main/resources/";
    private  String url = "http://live.demoguru99.com/index.php/";
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
       Home home = new Home(this.driver);
       home.clickOnAdvanceSearch();
       Thread.sleep(1500);

        AdvanceSearch advanceSearch = new AdvanceSearch(this.driver);
        advanceSearch.enterPrice("0");
       advanceSearch.enterPriceTo("150");
       advanceSearch.clickSearch();
       Thread.sleep(2000);

       AdvanceSearchResult advanceSearchResult = new AdvanceSearchResult(this.driver);
       advanceSearchResult.printProductNames();
       advanceSearchResult.printProductPrices();
       advanceSearchResult.clickOnModifySearch();


       advanceSearch.enterPrice("151");
       advanceSearch.enterPriceTo("1000");
       advanceSearch.clickSearch();
       Thread.sleep(2000);
       advanceSearchResult.printProductNames();
       advanceSearchResult.printProductPrices();
    }
    @AfterTest
    public void after(){
        driver.quit();
    }
}
