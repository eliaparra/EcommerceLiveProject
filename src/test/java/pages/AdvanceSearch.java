package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AdvanceSearch {
    private WebDriver driver;
    By price = By.id("price");
    By priceTo = By.id("price_to");
    By searchButton = By.xpath("//*[@id=\"form-validate\"]/div[2]/button");

    public AdvanceSearch(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void enterPrice(String priceText){
        escribir(price,priceText);
    }
    public void enterPriceTo(String priceToText){
        escribir(priceTo,priceToText);
    }

    public void clickSearch(){
        click(searchButton);
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }

    private void escribir(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
}
