package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyOrders {
    private WebDriver driver;

    By viewOrderLink = By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr/td[6]/span/a[1]");
    By firstOrder = By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr/td[1]");
    By statusFirstOrder = By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr/td[5]");


    public MyOrders(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void clickOnViewOrder(){
        click(viewOrderLink);
    }
    public String  getFirstOrder(){
        return getText(firstOrder);
    }
    public String getStatusFirstOrder(){
        return getText(statusFirstOrder);
    }

    private String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }

}
