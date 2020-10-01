package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CustomerInformation {
    private WebDriver driver;
    By accountInformation = By.linkText("Account Information");
    By webSiteAssociated = By.id("_accountwebsite_id");
    By createdFrom = By.id("_accountcreated_in");
    By newPassword = By.id("_accountnew_password");

    public CustomerInformation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void clickAccountInformation(){
        click(accountInformation);
    }
    public boolean checkWebSiteAssociated(){
        return checkDisabled(webSiteAssociated);
    }
    public boolean checkCreatedFrom(){
        return checkDisabled(createdFrom);
    }
    public boolean checkNewPassword(){
        return checkDisabled(newPassword);
    }
    private boolean checkDisabled(By locator) {
        return driver.findElement(locator).isEnabled();
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }
}
