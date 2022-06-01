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

    @FindBy(xpath = "//input[@class='form-control required']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement PasswordButonu;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement LoginButonu2;


    @FindBy(xpath = "//span[text()='ListOfUsers']")
    public WebElement listOfUsersYaziElementi;


    @FindBy(xpath = "//div[@id='divMessageResult']")
    public WebElement tryagainpleaseYaziElementi;

    @FindBy(xpath = "//a[@id='menuHotels']")
    public WebElement hotelManagementButonu;

    @FindBy(xpath = "//a[@href='/admin/HotelAdmin']")
    public WebElement hotelListButonu;


    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addHotelButonu;

    @FindBy(xpath = "//input[@id='Code']")
    public WebElement codeButonu;


    @FindBy(xpath = "//input[@id='Name']")
    public WebElement nameButonu;

    @FindBy(xpath = "//input[@id='Address']")
    public WebElement adressButonu;


    @FindBy(xpath = "//input[@id='Phone']")
    public WebElement phoneButonu;

    @FindBy(xpath = "//input[@id='Email']")
    public WebElement emailButonu;

    @FindBy(xpath = "//select[@id='IDGroup']")
    public WebElement idGroupButonu;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButonu;


    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement successfullyYaziElementi;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement okButonu;



}

