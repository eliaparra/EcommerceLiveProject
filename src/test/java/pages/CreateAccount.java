package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {
    private WebDriver driver;

    By firstName = By.id("firstname");
    By middleName = By.id("middlename");
    By lastName = By.id("lastname");
    By email = By.id("email_address");
    By password = By.id("password");
    By confirmPassword = By.id("confirmation");
    By registerButton = By.xpath("//*[@id='form-validate']/div[2]/button");

    public CreateAccount(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void enterFirstName(String firstNameText){
        escribir(firstName,firstNameText);
    }
    public void enterMiddleName (String middleNameText){
        escribir(middleName,middleNameText);
    }
    public void enterLastName(String lastNameText){
        escribir(lastName,lastNameText);
    }
    public void enterEmail(String emailText){
        escribir(email,emailText);
    }
    public void enterPassword(String passwordText){
        escribir(password,passwordText);
    }
    public void enterConfirmPassword(String confirmPasswordText){
        escribir(confirmPassword,confirmPasswordText);
    }
    public void clickRegister(){
        click(registerButton);
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }

    private void escribir(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }
}
