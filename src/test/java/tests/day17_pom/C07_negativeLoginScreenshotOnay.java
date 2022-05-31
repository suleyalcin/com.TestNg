package tests.day17_pom;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C07_negativeLoginScreenshotOnay {
    //Bir class olusturun:Negative Test

    //Bir test methodu olusturun negativeLoginTest()

    @Test
    public void negativeLoginTest() throws InterruptedException, IOException {

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
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();//bir takeScreen objesi olusturdum.driverin ustune yukledim .
        // beraber sayfaya gidecekler ve sayfanin goruntusunu alabilecek
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);
        System.out.println("TARIH : " + tarih);
        File tumSayfaResim = new File("target/ekranGoruntuleri/tumEkranResim" + tarih + ".jpeg");//her calistirdigimizda eskinin uzerine fotoyu kaydeder
        //dinamik olsun eskisinide silmesin silmek istersem ben silebileyim dedigimiz icin tarih atar
        // farkli farkli kaydetmis oluruz.birbirinin ustune kaydetmez
        //2.asama olusturacagimiz resmi kaydedecegimiz dosyayi olusturduk
        //dosya yolunu gostererk nereye kaydedecegini gosterdim.targetin altinda ekrangoruntuleri klasoru actim
        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);
        //Taekescreenshot objesini kullanarak gecici bir file'a asssign edelim
        FileUtils.copyFile(geciciDosya, tumSayfaResim);//tumSayfaResimi geciciDosyama kopyaladim
        Thread.sleep(2000);
    }
}
