package tests.day17_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.FacebookPage;
import utilities.Driver;

public class C03_PageClassKullanimi {
    @Test
    public void test01() throws InterruptedException {

        FacebookPage facebookPage = new FacebookPage();
        //facebook anasayfaya gidin

        Driver.getDriver().get("https://www.faceboook.com");

        //cikarsa cookies kabul edin
        facebookPage.gelismisButonu.click();
        facebookPage.guvenliDegilButonu.click();
        //facebookPage.cookiesButonu.click(); cookies ciksaydi boyle yapardik
        Thread.sleep(5000);

        //kullanici mail kutusuna rastgele bir isim yazdirin
        Faker faker=new Faker();
        facebookPage.mailKutusu.sendKeys(faker.internet().emailAddress());
        Thread.sleep(5000);


        //kullanici sifre kutusuna rastgele bir password yazdirin
        facebookPage.sifreKutusu.sendKeys(faker.internet().password());
        //login butonuna basin
        facebookPage.loginTusu.click();
        Thread.sleep(5000);

        //giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());
        Thread.sleep(5000);
        Driver.closeDriver();

    }
}
