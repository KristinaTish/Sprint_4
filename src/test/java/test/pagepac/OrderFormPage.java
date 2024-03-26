package test.pagepac;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderFormPage {
    private final WebDriver driver;

    public OrderFormPage (WebDriver driver){
        this.driver = driver;

    }



    public void fillInOrderForm(String name, String surname, String address, int metroValue, String phoneNumber, String date, String duration, String colour) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[contains(@class,'Input_Responsible__1jDKN')]")));
        driver.findElement(By.xpath(".//input[@placeholder = '* Имя']")).sendKeys(name);
        driver.findElement(By.xpath(".//input[@placeholder = '* Фамилия']")).sendKeys(surname);
        driver.findElement(By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']")).sendKeys(address);
        driver.findElement(By.className("select-search__input")).click();
        driver.findElement(By.xpath(".//button[@value='"+metroValue+"']")).click();
        driver.findElement(By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']")).sendKeys(phoneNumber);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[contains(@class,'Button_Middle__1CSJM')]")));
        driver.findElement(By.xpath(".//button[contains(@class,'Button_Middle__1CSJM')]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@placeholder = '* Когда привезти самокат']")));
        driver.findElement(By.xpath(".//input[@placeholder = '* Когда привезти самокат']")).click();
        driver.findElement(By.xpath(".//div[contains(@class,'react-datepicker__day--"+date+"')]")).click();
        driver.findElement(By.className("Dropdown-placeholder")).click();
        driver.findElement(By.xpath(".//div[contains(text(),'"+duration+"')]")).click();
        driver.findElement(By.xpath(".//input[@id='"+colour+"']")).click();
        driver.findElement(By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[contains(text(),'Заказать')]")).click();
    }

}
