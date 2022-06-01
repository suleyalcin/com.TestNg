package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class HomeworkNegativeSmokeTest {
    //1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
    //3 Farkli test Methodunda 3 senaryoyu test et
    HotelMyCampPage hmcPage;

    @Test
    public void yanlisSifreTest1() throws InterruptedException {
        //- yanlisSifre
        //test data yanlis username: manager1 , yanlis password : manager1
        //2) https://www.hotelmycamp.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCampUrl"));
        //3) Login butonuna bas
        hmcPage = new HotelMyCampPage();
        hmcPage.LoginButonu.click();

        //4)// test data  wrong username=manager1 ,

        hmcPage.userName.sendKeys(ConfigReader.getProperty("hmcWrongUsername"));

        // test data ValidPassword :Manager1!
        hmcPage.PasswordButonu.sendKeys(ConfigReader.getProperty("hmcValidPassword"));

        //4) Verilen senaryolar ile giris yapilamadigini test et
        Assert.assertTrue(hmcPage.LoginButonu2.isDisplayed());
        Thread.sleep(3000);

        Driver.closeDriver();

    }

    //*************************************************************//

    //- yanlisKulllanici=yanlis password : manager1
    @Test
    public void yanlisKullanici() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCampUrl"));
        //3) Login butonuna bas
        hmcPage = new HotelMyCampPage();
        hmcPage.LoginButonu.click();

        //4)// test data  valid username=manager
        hmcPage.userName.click();
        hmcPage.userName.sendKeys(ConfigReader.getProperty("hmcValidUsername"));

        // test data WrongPassword :manager1
        hmcPage.PasswordButonu.sendKeys(ConfigReader.getProperty("hmcWrongPassword"));

        //4) Verilen senaryolar ile giris yapilamadigini test et
        Assert.assertTrue(hmcPage.LoginButonu2.isDisplayed());
        Thread.sleep(3000);

        Driver.closeDriver();


    }


    //***************************************************************//
    //- yanlisSifreKullanici=yanlis username: manager1 , yanlis password : manager1
    @Test
    public void yanlisSifreYanlisKullanici() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("hotelMyCampUrl"));
        //3) Login butonuna bas
        hmcPage = new HotelMyCampPage();
        hmcPage.LoginButonu.click();

        //4)// test data  Wrong username=manager1 ,
        hmcPage.userName.sendKeys(ConfigReader.getProperty("hmcWrongUsername"));

        // test data WrongPassword :manager1
        hmcPage.PasswordButonu.sendKeys(ConfigReader.getProperty("hmcWrongPassword"));

        //4) Verilen senaryolar ile giris yapilamadigini test et
        Assert.assertTrue(hmcPage.LoginButonu2.isDisplayed());
        Thread.sleep(3000);

        Driver.closeDriver();
        Driver.getDriver().quit();
    }
}
