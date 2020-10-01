package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductPageMobile {
    private WebDriver driver;

    By price = By.className("price");
    public ProductPageMobile(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getPrice(){
       return getPrice(price);
    }

    private String getPrice(By price) {
        return  driver.findElement(price).getText();
    }
}
