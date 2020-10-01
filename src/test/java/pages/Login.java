package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Login {
    private WebDriver driver;

    By createAccountButton = By.xpath("//*[@id='login-form']/div/div[1]/div[2]/a");
    By email = By.id("email");
    By password = By.id("pass");
    By loginButton = By.id("send2");

    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void clickCreateAccountButton(){
        click(createAccountButton);
    }
    public void enterEmail(String emailText){
        escribir(email,emailText);
    }
    public void enterPassword(String passText){
        escribir(password,passText);
    }
    public void clickLogin(){
        click(loginButton);
    }

    private void escribir(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }
}
