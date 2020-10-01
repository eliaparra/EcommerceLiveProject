package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ThankYouPage {
    private WebDriver driver;

    By orderNumber = By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/p[1]/a");
    By message = By.tagName("h1");

    public ThankYouPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public String getOrderNumber(){
        System.out.println(getText(orderNumber));
        return getText(orderNumber);
    }
    public String getMessage(){
        return getText(message);
    }

    private String getText(By locator) {
        return driver.findElement(locator).getText();
    }
}
