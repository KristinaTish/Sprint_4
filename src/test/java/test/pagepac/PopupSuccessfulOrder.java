package test.pagepac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopupSuccessfulOrder {
    private final WebDriver driver;
    public PopupSuccessfulOrder(WebDriver driver){
        this.driver = driver;
    }
    public void orderConfirmedCheckStatusButtonShown() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[contains(text(),'Посмотреть статус')]")));
    }
}
