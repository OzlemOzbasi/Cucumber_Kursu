package StepDefinitions;

import Pages.DialogContent;
import Utilities.GenelWebDriver;
import io.cucumber.java.en.*;     //  bunun sonuna  *  ( yıldız ) ısaretını koyunca  asagıda kırmızı olan   Given  When  Then  duzelıyor
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class _01_LoginSteps {      // https://test.mersys.io/        username: turkeyts
                                   //                                password: TechnoStudy123

    DialogContent dc = new DialogContent();

    @Given("Navigate to Campus")
    public void navigateToCampus() {

        // System.out.println("merhaba 1");
        GenelWebDriver.getDriver().get("https://test.mersys.io/");
    }

    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {
        // System.out.println("merhaba 2");

       // waitleri var
//        WebDriverWait wait = new WebDriverWait(GenelWebDriver.getDriver(), Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOf(dc.username));
//

//        dc.username.sendKeys("turkeyts");
//        dc.password.sendKeys("TechnoStudy123");
//        dc.loginButton.click();


        //   1 .aşama

        dc.findAndSend("username","turkeyts");
        dc.findAndSend("password","TechnoStudy123");

        dc.findAndClick("loginButton");



    }


        @Then("User should login successfully")
        public void userShouldLoginSuccessfully() {

//        dc.waitUntilVisible(dc.dashboard);
//        Assert.assertTrue(dc.dashboard.getText().contains("Dashboard"));

            dc.findAndContainsText("dashboard","Dashboard");
            dc.findAndClick("acceptCookies");
        }


}