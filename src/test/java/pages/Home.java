package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Home {

    private WebDriver driver;

    By mobileLink = By.xpath("//*[@id='nav']/ol/li[1]/a");
    By pageTitle = By.className("page-title");
    By accountButton = By.xpath("//*[@id='header']/div/div[2]/div/a");
    By myAccountLink = By.xpath("//*[@id='header-account']/div/ul/li[1]/a");
    By logInLink = By.xpath("//*[@id='header-account']/div/ul/li[6]/a");
    By advanceSearch = By.xpath("//*[@id=\"top\"]/body/div/div/div[3]/div/div[3]/ul/li[3]/a");

    public Home(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnMobileLink(){
        click(mobileLink);
    }
    public void clickOnAdvanceSearch(){
        click(advanceSearch);
    }
    public String getTitle(){
       return  getText(pageTitle);
    }
    public void clickAccountButton(){
        click(accountButton);
    }
    public void clickMyAccountlink(){
        click(myAccountLink);
    }
    public void clickLogInLink(){
        click(logInLink);}

    private void click(By locator) {
        driver.findElement(locator).click();
    }

    private String getText(By locator) {
        return driver.findElement(locator).getText();
    }

}
