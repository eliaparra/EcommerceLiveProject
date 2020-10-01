package test;

import org.apache.tools.ant.taskdefs.condition.Or;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class TestDayTen {
    private String PATHDRIVER = "./src/main/resources/";
    private  String url = "http://live.demoguru99.com/index.php/backendlogin/";
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
        ordersBack.setFileExport("CSV");
        Thread.sleep(500);
        ordersBack.clickOnExport();

    }
    @AfterTest
    public void after(){
        driver.quit();
    }
}
