package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PendingReviewsBack {
    private WebDriver driver;

    By reviewId = By.name("review_id");
    By checkReviews = By.name("reviews");
    By editLink = By.linkText("Edit");


    public PendingReviewsBack(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void sortById(){
        click(reviewId);
    }
    public void checkReview(Integer order){
        clickElement(checkReviews,order);
    }
    public void clickEdit(Integer order){
        clickElement(editLink,order);
    }

    private void clickElement(By locator, Integer order) {
        List<WebElement> checks = driver.findElements(locator);
        checks.get(order).click();
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }

}
