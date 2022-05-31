package tests.day18_pom;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.TrendyolPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_KendiCalismamTrendyol {

    @Test
    public void test01() throws InterruptedException {
        TrendyolPage trendyolPage = new TrendyolPage();
        // trendyol anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("trendyolUrl"));

        // kadin erkek sing x butonuna click yapin
        trendyolPage.kadinErkekCarpiButonu.click();


        //kadin butonuna click yapin
        trendyolPage.kadinButonu.click();
        //cikan allerti engelleyin rededin




        //cok Satanlar butonuna click yapin
        trendyolPage.cokSatanlar.click();


        //sonuc listesinin textini yazdirin
        trendyolPage.cokSatanlarSonucListesi.getText();


        // sayfayi kapatin
        Driver.closeDriver();
    }


}
