package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginBack {

    private WebDriver driver;

    By userName = By.id("username");
    By password = By.id("login");
    By loginButton = By.xpath("//*[@id=\"loginForm\"]/div/div[5]/input");
    String userNameValue = "user01";
    String passwordValue = "guru99com";

    public LoginBack(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void loginBack (){
        borrar(userName);
        escribir(userName,userNameValue);
        borrar(password);
        escribir(password,passwordValue);
        click(loginButton);
    }
    private void click(By locator) {
        driver.findElement(locator).click();
    }
    private void escribir(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }
    private void borrar(By locator) {
        driver.findElement(locator).clear();
    }
}
