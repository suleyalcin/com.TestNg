package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {
    BrcPage brcPage;

    @Test
    public void yanlisSifre() throws InterruptedException {
        // Bir test method olustur positiveLoginTest()
        //		 https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //		login butonuna bas
        brcPage = new BrcPage();;
        brcPage.ilkLoginButonu.click();

        // test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        // test data wrong password : 54321
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        // login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();
        // Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et

        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());
        Thread.sleep(3000);

        Driver.closeDriver();
    }
    // bu class'da 2 test methodu daha olusturun

    @Test
    public void yanlisEmailDogruSifre() throws InterruptedException {
        // biri yanlis Kullanici=yanlis password

        //		 https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //		login butonuna bas
        brcPage = new BrcPage();;
        brcPage.ilkLoginButonu.click();

        // test data  wrong user email: client@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcWrongEmail"));

        // test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));

        // login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();

        // Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et

        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());
        Thread.sleep(3000);

        Driver.closeDriver();

    }
    // digeri de yanlis sifre ve kullanici adi
    @Test
    public void yanlisEmailYanlisSifre() throws InterruptedException {


        //		 https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //		login butonuna bas
        brcPage = new BrcPage();;
        brcPage.ilkLoginButonu.click();

        // test data  wrong user email: client@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcWrongEmail"));

        // test data wrong password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));

        // login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();

        // Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et

        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());
        Thread.sleep(3000);

        Driver.closeDriver();
        Driver.getDriver().quit();
    }
}
