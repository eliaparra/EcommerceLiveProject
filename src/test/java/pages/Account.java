package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Account {
    private WebDriver driver;

    By message = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span");
    By tvLink = By.xpath("//*[@id='nav']/ol/li[2]");
    By myWishList = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a");
    By myOrders = By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[4]/a");
    By reorderLink = By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr/td[6]/span/a[2]");

    public Account(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getMessage(){
        return getText(message);
    }
    public void clickOnTv(){
        click(tvLink);
    }
    public void clickOnMyWishlist(){
        click(myWishList);
    }
    public void clickOnMyOrders(){
        click(myOrders);
    }
    public void clickOnReorder(){
        click(reorderLink);
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }

    private String getText(By locator) {
      return   driver.findElement(locator).getText();
    }
}
