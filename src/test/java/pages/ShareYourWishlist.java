package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ShareYourWishlist {
    private WebDriver driver;

    By emailAddress = By.id("email_address");
    By shareWishlistButton = By.xpath("//*[@id='form-validate']/div[2]/button");
    public ShareYourWishlist(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void enterEmail(String email){
        escribir(emailAddress,email);
    }
    public void clickShareWishListButton(){
        click(shareWishlistButton);
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }

    private void escribir(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }
}
