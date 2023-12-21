package Pages;

import Utilities.GenelWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormContent extends Parent{

    public FormContent() {
        PageFactory.initElements( GenelWebDriver.getDriver(), this );
    }


    @FindBy(xpath = "//span[text(),'Academic Period'])[1]")
    private WebElement academicPeriod;


    @FindBy(xpath = "//span[contains(text(),' 2021-2022 ')]")
    private WebElement academicPeriod1;


    @FindBy(xpath = "//span[text(),'Grade Level']")
    private WebElement gradeLevel;


    @FindBy(xpath = "//span[@class='mat-option-text'])[3]")
    private WebElement gradeLevel2;






    WebElement myElement;


    public void findAndClick(String strElement){   // 2.aşama

        // burada string isimden weblemente ulaşıcam
        switch (strElement)
        {
            case "academicPeriod" : myElement = academicPeriod; break;
            case "academicPeriod1" : myElement = academicPeriod1; break;
            case "gradeLevel" : myElement = gradeLevel; break;
            case "gradeLevel2" : myElement = gradeLevel2; break;

        }

        clickFunction(myElement);

        if ( myElement == academicPeriod  ||  myElement == gradeLevel)
            GenelWebDriver.Bekle(2);

    }




}
