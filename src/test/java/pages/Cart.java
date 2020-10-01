package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Cart {
    private WebDriver driver;

    By inputQty = By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/input");
    By updateQty = By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/button");
    By errormsg = By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[2]/p");
    By empty_cart_button = By.id("empty_cart_button");
    By cartEmptymsg = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div/div[1]/h1");
    By countrySelector = By.id("country");
    By regionSelector = By.id("region_id");
    By zipCodeInput = By.id("postcode");
    By estimateLink = By.xpath("//*[@id='shipping-zip-form']/div/button");
    By rateRadio = By.id("s_method_flatrate_flatrate");
    By shippingCost = By.xpath("//*[@id='co-shipping-method-form']/dl/dd/ul/li/label/span");
    By updateTotalButton = By.xpath("//*[@id=\"co-shipping-method-form\"]/div/button");
    By subtotal = By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tbody/tr[1]/td[2]/span");
    By grandTotal = By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]/strong/span");
    By proceedToCheckoutButton = By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button");
    By coupon_code = By.id("coupon_code");
    By applyCouponcode = By.xpath("//*[@id=\"discount-coupon-form\"]/div/div/div/div/button");
    By discount = By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tbody/tr[2]/td[2]");

    public Cart(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void setQty(Integer qty){
        borrar(inputQty);
        escribir(inputQty,qty.toString());
    }
    public void setCoupoCode(String code){
        borrar(coupon_code);
        escribir(coupon_code,code);
    }
    public void clickApplyCoupon(){
        click(applyCouponcode);
    }
    public Float getDiscount(){
        return getDiscount(discount);
    }

    private void borrar(By locator) {
        driver.findElement(locator).clear();
    }

    public void clickUpdateQty(){
        click(updateQty);
    }
    public String getErrorMsg (){
       return getText(errormsg);
    }
    public void clickEmptyCart(){
        click(empty_cart_button);
    }
    public String getTitle(){
        return getText(cartEmptymsg);
    }
    public void setCountry(String countryText){
        setSelector(countrySelector,countryText);
    }
    public void setRegion(String regionText){
        setSelector(regionSelector,regionText);
    }
    public void enterZip(Integer zip){
        escribir(zipCodeInput,zip.toString());
    }
    public void clickOnEstimate(){
        click(estimateLink);
    }
    public Float getShippingCost(){
        return getPrice(shippingCost);
    }
    public void clickUpdateTotal(){
        click(updateTotalButton);
    }
    public Float getSubtotal(){
        return getPrice(subtotal);
    }
    public Float getGrandTotal(){
        return getPrice(grandTotal);
    }
    public void clickProceedToCheckout(){
        click(proceedToCheckoutButton);
    }
    public void clickRateRadio(){
        click(rateRadio);
    }

    private Float getPrice(By locator){
       String cost = getText(locator);
       String costnumbers = cost.substring(1);
       System.out.println(costnumbers);
       if(costnumbers.contains(",")){
           String valueStr = costnumbers.replace(",","");
           return Float.parseFloat(valueStr);
       }else{
           return Float.parseFloat(costnumbers);
       }
    }

    private Float getDiscount(By locator){
        String cost = getText(locator);
        String costnumbers = cost.substring(2);
        System.out.println(costnumbers);
        if(costnumbers.contains(",")){
            String valueStr = costnumbers.replace(",","");
            return Float.parseFloat(valueStr);
        }else{
            return Float.parseFloat(costnumbers);
        }
    }

    private void setSelector(By locator, String text) {
        Select selector = new Select(driver.findElement(locator));
        selector.selectByVisibleText(text);
    }

    private String getText(By locator) {
        return  driver.findElement(locator).getText();
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }
    private void escribir(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }
}
