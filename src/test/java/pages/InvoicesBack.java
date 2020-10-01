package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InvoicesBack {
    private WebDriver driver;

    By invoiceDate = By.name("created_at");

    public InvoicesBack(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void sortInvoiceDate(){
        click(invoiceDate);
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }
}
