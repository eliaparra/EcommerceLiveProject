package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Review {
    private WebDriver driver;

    By reviewField = By.id("review_field");
    By summaryField = By.id("summary_field");
    By nicknameField = By.id("nickname_field");
    By submitReviewButton = By.xpath("//*[@id=\"review-form\"]/div[2]/button");

    public Review(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void enterReview(String texto){
        borrar(reviewField);
        escribir(reviewField,texto);
    }
    public void enterSummary(String texto){
        borrar(summaryField);
        escribir(summaryField,texto);
    }
    public void enterNickname(String texto){
        borrar(nicknameField);
        escribir(nicknameField,texto);
    }
    public void clickSubmitReview(){
        click(submitReviewButton);
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }

    private void borrar(By locator) {
        driver.findElement(locator).clear();
    }

    private void escribir(By locator, String texto) {
        driver.findElement(locator).sendKeys(texto);
    }
}
