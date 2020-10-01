package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
    private WebDriver driver;

    By printOrderLink = By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div[1]/a[2]");

    public OrderPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickPrintOrder(){
        click(printOrderLink);
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }
}
