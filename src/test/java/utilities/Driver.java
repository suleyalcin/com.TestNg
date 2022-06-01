package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
   POM'de Driver icin TestBase class'ina extends etmek yerine
   Driver class'indan static method'lar kullanarak
   driver olusturup, ilgili ayarlarin yapilmasi
   ve en sonda driver'in kapatilmasi tercih edilmistir.

   POM' de Driver classindaki getDriver()'nin obje olusturularak kullanilmasina engel olmak icin Singleton Pattern kullanimi benimsenmistir.
   Singleton Pattern:tekli Kullanim,bir classin farkli class'lardan
   obje olusturularak kullanimi engellemek icin kullanilir.

   Bunu saglamak icin yapmamaiz gereken sey oldukca basit .
   Obje olusturmak icin kullanilan constructor'i private yaptiginizda baska classslarda Driver class'indan
   obje olusturulmasi mumkun degildir
    */
   private Driver(){

    }
    static WebDriver driver;
    public static WebDriver getDriver(){
        if (driver==null) {
            switch (ConfigReader.getProperty("browser")){//kocum ConfigReader; bir kosu ==>getProperty browser getir
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "Edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }
    public static void closeDriver() {
        if (driver != null) { // driver'a deger atanmissa
            driver.close();
            driver = null;
        }
    }
}