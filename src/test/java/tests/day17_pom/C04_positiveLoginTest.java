package tests.day17_pom;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C04_positiveLoginTest {
    //Bir class olusturun:Positive Test

    //Bir test methodu olusturun positiveLoginTest()

    @Test
    public void positiveLoginTest() throws InterruptedException {

        //https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com/");

        // login butonuna basin
        HotelMyCampPage hotelmycampPage = new HotelMyCampPage();
        hotelmycampPage.LoginButonu.click();;
        // test data username:manager;
        hotelmycampPage.userName.sendKeys("manager");

        // test data password:Manager1!
        hotelmycampPage.PasswordButonu.sendKeys("Manager1!");
        Thread.sleep(2000);
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test edin
        hotelmycampPage.LoginButonu2.click();
        Assert.assertTrue(hotelmycampPage.listOfUsersYaziElementi.isDisplayed());
        Thread.sleep(2000);
        Driver.closeDriver();


    }
}
