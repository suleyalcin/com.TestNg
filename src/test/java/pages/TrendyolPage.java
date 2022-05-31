package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TrendyolPage {

    public TrendyolPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css=("body.gender-popup-lock:nth-child(2) div:nth-child(1) div.modal div.modal-content div.modal-close > svg:nth-child(1)"))

    public WebElement kadinErkekCarpiButonu;

    @FindBy(xpath = "(//a[text()='Kadın'])[1]")
    public WebElement kadinButonu;

    @FindBy(xpath = "//img[@xpath='1']")
    public WebElement cokSatanlar;
    @FindBy(xpath = "//h1[text()='En Çok Satan Ürünler']")
    public WebElement cokSatanlarSonucListesi;

}
