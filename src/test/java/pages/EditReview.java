package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditReview {
    private WebDriver driver;

    By status = By.id("status_id");
    By saveReview = By.id("save_button");

    public EditReview(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void setStatus(String opcion){
        setSelector(status,opcion);
    }
    public void clickSave(){
        click(saveReview);
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }

    private void setSelector(By locator, String opcion) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(opcion);
    }
}
