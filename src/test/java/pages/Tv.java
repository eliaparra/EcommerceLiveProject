package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Tv {
    private WebDriver driver;

    By wishListLinkLGLCD = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a");


    public Tv(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void clickOnWishListLGLCD(){
        click(wishListLinkLGLCD);
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }
}
