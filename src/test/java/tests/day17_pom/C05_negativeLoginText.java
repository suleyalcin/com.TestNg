package tests.day17_pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C05_negativeLoginText {

    //Bir class olusturun:Negative Test

    //Bir test methodu olusturun negativeLoginTest()

    @Test
    public void negativeLoginTest() throws InterruptedException {

        //https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com/");

        // login butonuna basin
        HotelMyCampPage hotelmycampPage = new HotelMyCampPage();
        hotelmycampPage.LoginButonu.click();

        // test data username:manager1;//yanlis username dogrusu manager
        hotelmycampPage.userName.sendKeys("manager1");

        // test data password:manager1!//yanlis password dogrusu Manager1!
        hotelmycampPage.PasswordButonu.sendKeys("manager1!");
        Thread.sleep(2000);
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test edin
        hotelmycampPage.LoginButonu2.click();
        Assert.assertTrue(hotelmycampPage.tryagainpleaseYaziElementi.isDisplayed());
        Thread.sleep(2000);
        Driver.closeDriver();

    }
}