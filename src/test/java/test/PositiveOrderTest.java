package test;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.WebDriver;

import test.pagepac.*;

@RunWith(Parameterized.class)
public class PositiveOrderTest {
    @Rule

    public SwitcherForDrivers switcherForDrivers = new SwitcherForDrivers();

    private final String clientName;
    private final String clientSurname;
    private final String clientAddress;
    private final int  metroStationValue;
    private final String clientPhoneNumber;
    private final String deliveryDate;
    private final String rentDuration;
    private final String scooterColour;



    public PositiveOrderTest(String clientName,String clientSurname,String clientAddress, int metroStationValue, String clientPhoneNumber, String deliveryDate, String rentDuration, String scooterColour){
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientAddress = clientAddress;
        this.metroStationValue = metroStationValue;
        this.clientPhoneNumber = clientPhoneNumber;
        this.deliveryDate = deliveryDate;
        this.rentDuration = rentDuration;
        this.scooterColour = scooterColour;
    }

    @Parameterized.Parameters
    public static Object[][] fillClientData(){
        return new Object[][]{
                {"Мария","Иванова","Комсомольская,3",7,"+79045991274","030","сутки","grey"},
                {"Фатима","Ильназова","Фрунзе,7",148,"89045991274","020","шестеро суток","black"}
        };}




   @Test
    public void processOrderFromHeader() {

        WebDriver driver = switcherForDrivers.getDriver();

        MainPage main = new MainPage(driver);
        OrderFormPage form = new OrderFormPage(driver);
        PopupWantToOrder popup = new PopupWantToOrder(driver);
        PopupSuccessfulOrder status = new PopupSuccessfulOrder(driver);
        main.openSite();
        main.closeCookies();
        main.pushOrderButtonInHeader();
        form.fillInOrderForm(clientName, clientSurname, clientAddress, metroStationValue, clientPhoneNumber, deliveryDate, rentDuration, scooterColour);
        popup.confirmNewOrder();
        status.orderConfirmedCheckStatusButtonShown();
    }




    @Test
    public void processOrderFromButtonAfterRoadmap (){

        WebDriver driver = switcherForDrivers.getDriver();

        MainPage main = new MainPage(driver);
        OrderFormPage form = new OrderFormPage(driver);
        PopupWantToOrder popup = new PopupWantToOrder(driver);
        PopupSuccessfulOrder status = new PopupSuccessfulOrder(driver);
        main.openSite();
        main.closeCookies();
        main.pushOrderButtonAfterRoadmap();
        form.fillInOrderForm(clientName, clientSurname, clientAddress, metroStationValue, clientPhoneNumber, deliveryDate, rentDuration, scooterColour);
        popup.confirmNewOrder();
        status.orderConfirmedCheckStatusButtonShown();

    }


}


