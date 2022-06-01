package tests.day19_smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class HomeworkE2eTesting {
    HotelMyCampPage hmcPage;
    @Test
    public void createHotel() throws InterruptedException {

//3. https://www.hotelmycamp.com adresine git.
        Driver.getDriver().get("https://www.hotelmycamp.com ");
//4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri girin.
        hmcPage=new HotelMyCampPage();
        hmcPage.LoginButonu.click();
//a. Username : manager
        hmcPage.userName.sendKeys(ConfigReader.getProperty("hmcValidUsername"));
//b. Password : Manager1!
        hmcPage.PasswordButonu.sendKeys(ConfigReader.getProperty("hmcValidPassword"));
//5. Login2 butonuna tıklayın.
        hmcPage.LoginButonu2.click();
//6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        Thread.sleep(3000);
        hmcPage.hotelManagementButonu.click();
        hmcPage.hotelListButonu.click();
        hmcPage.addHotelButonu.click();
        Thread.sleep(3000);
//7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        hmcPage.codeButonu.sendKeys("safranbolu");
        hmcPage.nameButonu.sendKeys("sule");
        hmcPage.adressButonu.sendKeys("karabuk");
        hmcPage.phoneButonu.sendKeys("444444");
        hmcPage.emailButonu.sendKeys("abc@gmail.com");
        WebElement dropDownMenu=Driver.getDriver().findElement(By.xpath("//select[@id='IDGroup']"));
        Select select=new Select(dropDownMenu);
        select.selectByVisibleText("Hotel Type2");

//8. Save butonuna tıklayın.
        hmcPage.saveButonu.click();
        Thread.sleep(3000);
//9. “Hotel was inserted successfully” textinin göründüğünü test edin.

        hmcPage.successfullyYaziElementi.isEnabled();
        String actualText=hmcPage.successfullyYaziElementi.getText();
        SoftAssert softAssert = new SoftAssert();
        String expectedText="Hotel was inserted successfully";
        softAssert.assertEquals( actualText, expectedText);

//10. OK butonuna tıklayın
        hmcPage.okButonu.click();
        Thread.sleep(3000);
        Driver.closeDriver();

    }
}
