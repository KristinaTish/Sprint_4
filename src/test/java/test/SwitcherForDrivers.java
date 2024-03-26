package test;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitcherForDrivers extends ExternalResource {
    private WebDriver driver;

    @Override
    protected void before() throws Throwable {
        initDriver();
    }

    @Override
    protected void after() {
        driver.quit();
    }

    public void initDriver(){
        if("firefox".equals(System.getProperty("browser"))){
           initFirefox();
        }
        else{
            initChrome();
        }
    }
    private void initFirefox(){
        driver = new FirefoxDriver();
    }
    private void initChrome(){
        driver = new ChromeDriver();
    }
    public WebDriver getDriver(){
        return driver;
    }

}
