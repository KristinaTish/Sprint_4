package test.pagepac;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
//главная страница Яндекс.Самоката

public class MainPage {
    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openSite() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    } //открыть сайт
    public void closeCookies() {
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
    } //закрыть окно с куками
    public void pushOrderButtonInHeader() {
        driver.findElement(By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']")).click(); //нажать на кнопку "Заказать" в верхней панели
    }
    public void pushOrderButtonAfterRoadmap(){
        driver.findElement(By.xpath(".//div[@class = 'Home_FinishButton__1_cWm']/button[contains(@class, 'Button_Button__ra12g')]")).click();
    } // нажать на кнопку "Заказать" внизу страницы

    public void clickOnFaqItem(String num) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Home_FAQ__3uVm4")));
        WebElement element = driver.findElement(By.id("accordion__heading-"+num));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.id("accordion__heading-"+num)).click(); //нажать на пункт раскрывающегося списка с вопросами и ответами
    }

   public void compareAnswerText(String num, String answer) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@aria-labelledby ='accordion__heading-"+num+"']")));
        String actualAnswerText = driver.findElement(By.xpath(".//div[@id = 'accordion__panel-"+num+"']/p")).getText();

        assertEquals("Текст ответа не совпадает с ожидаемым! ",answer,actualAnswerText); //сравнить ФР и ОР текста ответа
    }

   public void compareQuestionText(String num,String question) {
        String actualQuestionText = driver.findElement(By.id("accordion__heading-"+num)).getText();
        assertEquals("Текст вопроса не совпадает с ожидаемым! ",question,actualQuestionText); //сравнить ФР и ОР текста вопроса
    }
}
