package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class Mobile {
    private WebDriver driver;

    By selectorSortBy = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select");
    By productName = By.className("product-name");
    By pageTitle = By.cssSelector(".category-title");
    By price = By.id("product-price-1");
    By imageXperia = By.id("product-collection-image-1");
    By addToCartXperia = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button");
    By addToCartIPhone = By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/button");
    By addToCompareXperia = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a");
    By addToCompareIPhone = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a");
    By compareButton = By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-right.sidebar > div.block.block-list.block-compare > div.block-content > div > button > span > span");
    By reviewTab = By.xpath("//*[@id=\"top\"]/body/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/ul/li[2]");
    By reviewComment = By.xpath("//*[@id=\"customer-reviews\"]/dl");


    public Mobile(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void setSelectorSortBy(String opcion) {
        setSelector(selectorSortBy, opcion);
    }

    public String getTitle() {
        return getText(pageTitle);
    }
    public String getReviewComment(){
        return  getText(reviewComment);
    }

    public String getFirstProduct() {
        return getText(productName);
    }

    public String getSecondProduct() {
        return getText(productName);
    }

    public String getThirdProduct() {
        return getText(productName);
    }

    public String getPrice() {
        return getText(price);
    }

    public void clickOnXperia() {
        click(imageXperia);
    }
    public void clickOnReviewTab(){
        click(reviewTab);
    }

    public void clickOnAddToCartXperia() {
        click(addToCartXperia);
    }
    public void clickOnAddtoCartIPhone(){
        click(addToCartIPhone);
    }

    public void clickOnCompareButton() {
        click(compareButton);
    }

    public void addToCompareXperia() {
        click(addToCompareXperia);
    }

    public void addToCompareIPhone() {
        click(addToCompareIPhone);
    }


    private String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }

    private void setSelector(By locator, String text) {
        Select selector = new Select(driver.findElement(locator));
        selector.selectByVisibleText(text);
    }


}
