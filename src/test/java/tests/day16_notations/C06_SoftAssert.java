package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C06_SoftAssert extends TestBase {
        /*Soft Assertion baslangic ve bitis satirlari arasindaki tum assertionlari
        yapip bitis satirina geldiginde bize buldugu tum hatalari rapor eder
         */
    //VERIFICATION=SOFT ASSERT==>DOGRULAMA
    //soft assert"'un baslangici obje olusturmaktir.
    SoftAssert softAssert=new SoftAssert();

    @Test
    public void test01() {
        //1-amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2-Title in amazon icerdigini test edin
        String expectedTitle="amazon";
        String actualTitle=driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"SULEM title amazon icermiyor");
        //3-arama kutusunun erisilebilir oldugunu test edin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(),"arama kutusuna erisilemiyor");
        //4-arama Kutusuna Nutella yaziip aratin
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //5-arama yapildigini test edin
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYaziElementi.isDisplayed(),"arama yapilamadi");
        //6-arama sonucunun Nutella icerdigini test edin
        softAssert.assertTrue(sonucYaziElementi.getText().contains("Kutella"),"SULEM sonuc Kutella icermiyor");
        //softassert'e bitis satirini bildirmek icin assertAll(); methodu kullanilir
        //Bu satir yazilmazsa asssertion gorevi yapilmamis olur=perform eklemek gibi
        softAssert.assertAll();
        /*SoftAssertion'in hata bulsa bile calismaya devam etme ozelligi asssertAll'a kadardir.
        Eger AssertAll()'da failed rapor edilirse calsima durur ve class'in kalan kismi calistirilmaz
        (Yani AssetAll hardAasertdeki her bir assertt gibidir,hatayi yakalrsa calisma durur
        */
        System.out.println("assertion'lardan failed olan yoksa; burasi calisir");
    }

}
