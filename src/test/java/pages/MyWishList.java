package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyWishList {
    private WebDriver driver;

    By shareWhishlistButton = By.name("save_and_share");
    By message = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span");
    By addToCartButton = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/form[1]/div/table/tbody/tr/td[5]/div/button");


    public MyWishList(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void clickWhislistButton(){
        click(shareWhishlistButton);
    }
    public String getMessage(){
       return  getText(message);
    }
    public void clickAddToCart(){
        click(addToCartButton);
    }

    private String getText(By locator) {
      return   driver.findElement(locator).getText();
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }
}
