package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Checkout {
    private WebDriver driver;

    By firstName = By.id("billing:firstname");
    By lastName = By.id("billing:lastname");
    By address = By.id("billing:street1");
    By city = By.id("billing:city");
    By region = By.id("billing:region_id");
    By zip = By.id("billing:postcode");
    By telephone = By.id("billing:telephone");
    By continueButtonBillingInformation = By.xpath("//*[@id=\"billing-buttons-container\"]/button");

    By continueButtonShippingmethod = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button");
    By checkMoneyRadio = By.id("p_method_checkmo");
    By continuePaymentInformation = By.xpath("//*[@id=\"payment-buttons-container\"]/button");
    By placeOrder = By.xpath("//*[@id=\"review-buttons-container\"]/button");

    public Checkout(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void enterFirstName(String text){
        escribir(firstName,text);
    }
    public void enterlastName(String text){
        escribir(lastName,text);
    }
    public void enterAddress(String text){
        escribir(address,text);
    }
    public void enterCity(String text){
        escribir(city,text);
    }
    public void setRegion(String text){
        setSelector(region,text);
    }
    public void enterZip(String text){
        escribir(zip,text);
    }
    public void enterTelephone(String text){
        escribir(telephone,text);
    }
    public void clickcontinueButtonBillingInformation(){
        click(continueButtonBillingInformation);
    }
    public void clickcontinueButtonShippingmethod(){
        click(continueButtonShippingmethod);
    }
    public void selectMoney(){
        click(checkMoneyRadio);
    }
    public void clickcontinuePaymentInformation(){
        click(continuePaymentInformation);
    }
    public void clickplaceOrder(){
        click(placeOrder);
    }


    private void click(By locator) {
        driver.findElement(locator).click();
    }

    private void setSelector(By locator, String text) {
        Select selector = new Select(driver.findElement(locator));
        selector.selectByVisibleText(text);
    }

    private void escribir(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }
}
