package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdvanceSearchResult {
    private WebDriver driver;

    By productName = By.className("product-name");
    By productPrice = By.className("price-box");
    By modifyYourSearchLink = By.linkText("Modify your search");


    public AdvanceSearchResult(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void printProductNames(){
        List<WebElement> products = driver.findElements(productName);
        for(int i=0;i<products.size();i++){
            System.out.println(products.get(i).getText());
        }
    }
    public void printProductPrices(){
        List<WebElement> products = driver.findElements(productPrice);
        for(int i=0;i<products.size();i++){
            System.out.println(products.get(i).getText());
        }
    }
    public void clickOnModifySearch(){
        click(modifyYourSearchLink);
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }
}
