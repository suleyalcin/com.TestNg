package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelMyCampPage {



    public HotelMyCampPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "(//a[@class=\"nav-link\"])[7]")
    public WebElement LoginButonu;

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement PasswordButonu;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement LoginButonu2;


    @FindBy(xpath = "//span[text()='ListOfUsers']")
    public WebElement listOfUsersYaziElementi;


    @FindBy(xpath = "//div[@id='divMessageResult']")
    public WebElement tryagainpleaseYaziElementi;
}

