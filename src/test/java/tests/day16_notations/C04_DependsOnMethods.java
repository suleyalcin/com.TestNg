package tests.day16_notations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C04_DependsOnMethods {
    /*
          DependsOnMethods test method'larinin calisma siralamasina karismaz
          Sadece bagli olan test, baglandigi testin sonucuna bakar
          baglandigi test PASSED olmazsa, baglanan test hic calismaz(ignore)
         */
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Before Class");
    }

    @AfterClass

    public void tearDown() {
        driver.close();
        System.out.println("After Class");
    }
    @Test
    public void test01() {
    driver.get("https://www.amazon.com");
        System.out.println("test01");

    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        //amazonda Nutella aratalim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        System.out.println("test02");


    }

    @Test(dependsOnMethods = "test02")
    public void test03() {
        //sonuc yazisinin nutella icerdigini test edelim
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        Assert.assertTrue(sonucYaziElementi.getText().contains("Nutella"));
        System.out.println("test03");

    }

    @Test(groups = {"grup1", "grup2"})
    public void test04() {
        System.out.println("Bak bu calisti");
    }
}
