package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class CustomersBack {
    private WebDriver driver;

    By closeAlert = By.xpath("//*[@id=\"message-popup-window\"]/div[1]/a");
    By salesLink = By.xpath("//*[@id=\"nav\"]/li[1]/a");
    By invoicesLink = By.xpath("//*[@id=\"nav\"]/li[1]/ul/li[2]/a");
    By catalogLink = By.xpath("//*[@id=\"nav\"]/li[2]/a");
    By reviewsandRatings = By.xpath("//*[@id=\"nav\"]/li[2]/ul/li/a");
    By customerReviews = By.xpath("//*[@id=\"nav\"]/li[2]/ul/li/ul/li[1]/a");
    By pendingReviews = By.xpath("//*[@id=\"nav\"]/li[2]/ul/li/ul/li[1]/ul/li[1]/a");
    By ordersLink = By.xpath("//*[@id=\"nav\"]/li[1]/ul/li[1]/a");
    By customersLink = By.xpath("//*[@id=\"nav\"]/li[3]/a");
    By manageCustomersLink = By.xpath("//*[@id=\"nav\"]/li[3]/ul/li/a");


    public CustomersBack(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void clickSalesLink(){
        hoverElement(salesLink);
    }
    public void clickCatalogLink(){
        hoverElement(catalogLink);
    }
    public void clickInvoicesLink(){
        click(invoicesLink);
    }
    public void clickCustomersLink(){
        hoverElement(customersLink);
    }
    public void clickmanageCustomersLink(){
        click(manageCustomersLink);
    }
    public void clickReviewsandRatingsLink(){
        hoverElement(reviewsandRatings);
    }
    public void clickCustomerReviewsLink(){
        hoverElement(customerReviews);
    }
    public void clickPendingReviewsLink(){
        click(pendingReviews);
    }

    private void hoverElement(By locator) {
        Actions action = new Actions(this.driver);
        action.moveToElement(driver.findElement(locator)).perform();
    }

    public void clickOrdersLink(){
        click(ordersLink);
    }
    public void closeAlert(){
        click(closeAlert);
    }
    private void click(By locator) {
        driver.findElement(locator).click();
    }

}
