package Pages;

import Utilities.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DialogContent extends Parent{

    public DialogContent() {
        PageFactory.initElements( GenelWebDriver.getDriver(), this );
    }


    @FindBy(css = "input[formcontrolname='username']")
    private  WebElement username;

    @FindBy(css="input[formcontrolname='password']")
    private  WebElement password;

    @FindBy(css="button[aria-label='LOGIN']")
    private  WebElement loginButton;

    @FindBy(xpath="(//span[contains(text(),'Dashboard')])[2]")
    private  WebElement dashboard;

    @FindBy(xpath="//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")    // button  larda locator bulurken ms sinden bulmamız ıyı olur
    private  WebElement addButton;

    @FindBy(xpath="//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath="//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;

    @FindBy(xpath="//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successMessage;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortName;

    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    private WebElement alreadyExist;

    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    private WebElement closeDialog;

/*
    @FindBy(xpath = "//ms-text-field[contains@placeholder,'FIELD.NAME']//input")
    private WebElement searchInput;          */

    @FindBy(xpath = "(//div[contains(@class,'mat-form-field-infix ng-tns-c74')]//input)[1]")
    private WebElement searchInput;


    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;


    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement deleteButton;


    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElement deleteDialogBtn;


    @FindBy(xpath = "//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']//input")
    private WebElement integrationCode;


    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement priorityCode;


    @FindBy(xpath = "//button[@class='consent-give'])[1]")
    private WebElement acceptCookies;




    WebElement myElement;
    public void findAndSend(String strElement, String value){    // 2.aşama

        // burada string isimden weblemente ulaşıcam

        switch (strElement)            //  burası  getter setter gorevı yapıyormus gıbı oldu , yukarıları prıvate yapınca
        {
            case "username" : myElement = username; break;
            case "password" : myElement = password; break;
            case "nameInput" : myElement = nameInput; break;
            case "codeInput" : myElement = codeInput; break;
            case "shortName" : myElement = shortName; break;
            case "searchInput" : myElement = searchInput; break;
            case "integrationCode" : myElement = integrationCode; break;
            case "priorityCode" : myElement = priorityCode; break;
        }

        sendKeysFunction(myElement, value);
    }



    public void findAndClick(String strElement){   // 2.aşama

        // burada string isimden weblemente ulaşıcam
        switch (strElement)
        {
            case "loginButton" : myElement = loginButton; break;
            case "addButton" : myElement = addButton; break;
            case "saveButton" : myElement = saveButton; break;
            case "closeDialog" : myElement = closeDialog; break;
            case "searchButton" : myElement = searchButton; break;
            case "deleteButton" : myElement = deleteButton; break;
            case "deleteDialogBtn" : myElement = deleteDialogBtn; break;
            case "acceptCookies" : myElement = acceptCookies; break;

        }

        clickFunction(myElement);
    }


    public void findAndContainsText(String strElement, String text){    // 2.aşama

        // burada string isimden weblemente ulaşıcam
        switch (strElement)
        {
            case "dashboard" : myElement = dashboard; break;
            case "successMessage" : myElement = successMessage; break;
            case "alreadyExist" : myElement = alreadyExist; break;
        }

        verifyContainsText(myElement,text);
    }




    public void SearchAndDelete(String searchText){

        // scrollUp()   --- web sayfasının yan cızgısını yukarı kaydırmak ıcın

        findAndSend("searchInput", searchText);  // arama kutucuğuna kelimeyi yaz (ARANACAK KELİMEYİ KUTUCUĞA GÖNDER)
        findAndClick("searchButton");            // arama butonuna bas


    //    waitUntilLoading();

    WebDriverWait wait = new WebDriverWait (GenelWebDriver.getDriver(), Duration.ofSeconds(30) );
    wait .until(ExpectedConditions.textToBe(By.cssSelector("div[fxlayoutalign='center center'][class='control-full'] "), "Search"));


        findAndClick("deleteButton");            // silme butonuna bas
        findAndClick("deleteDialogBtn");         // dialogdaki silme butonuna bas

      }





    }
