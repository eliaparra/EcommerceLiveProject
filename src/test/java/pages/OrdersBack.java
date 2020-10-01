package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class OrdersBack {
    private WebDriver driver;

    By formatSelector = By.id("sales_order_grid_export");
    By exportButton = By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/table/tbody/tr/td[2]/button");
    By statusSelector = By.id("sales_order_grid_filter_status");
    By searchButton = By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/table/tbody/tr/td[3]/button[2]");
    By checkboxOrders = By.name("order_ids");
    By actionsSelector = By.id("sales_order_grid_massaction-select");
    By submitButton = By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/div[1]/table/tbody/tr/td[2]/div/div[1]/form/fieldset/span[4]/button");
    By messages = By.id("messages");

    public OrdersBack(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void setActions(String texto){
        setSelector(actionsSelector,texto);
    }
    public String getMessage(){
        return getText(messages);
    }

    private String getText(By locator) {
        return  driver.findElement(locator).getText();
    }

    public void clickSubmit(){
        click(submitButton);
    }
    public void setFileExport(String opcion){
        setSelector(formatSelector,opcion);
    }
    public void clickOnExport(){
        click(exportButton);
    }
    public void setStatus(String opcion){
        setSelector(statusSelector,opcion);
    }
    public void clickSearch(){
        click(searchButton);
    }
    public void clickCheckBox(Integer order){
        clickCheckBox(checkboxOrders,order);
    }

    private void clickCheckBox(By locator, Integer order) {
        List<WebElement> checks = driver.findElements(locator);
        checks.get(order).click();
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }

    private void setSelector(By locator, String opcion) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(opcion);
    }
    public boolean isFileDownloaded(String downloadPath, String fileName) {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().contains(fileName))
                return flag=true;
        }
        return flag;
    }
}
