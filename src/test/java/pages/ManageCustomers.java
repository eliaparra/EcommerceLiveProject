package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ManageCustomers {
    private WebDriver driver;
    By firstEdit = By.xpath("//*[@id=\"customerGrid_table\"]/tbody/tr[1]/td[11]/a");

    public ManageCustomers(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void clickFirstEdit(){
        click(firstEdit);
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }
}
