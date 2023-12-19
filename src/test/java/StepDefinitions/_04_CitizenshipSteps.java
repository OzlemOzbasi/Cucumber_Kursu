package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _04_CitizenshipSteps {

    DialogContent dc = new DialogContent();


    @And("Navigate to Citizenship page")
    public void navigateToCitizenshipPage() {

        LeftNav ln = new LeftNav();
        ln.findAndClick("setupOne");
        ln.findAndClick("parameters");
        ln.findAndClick("citizenShip");     // Citizenship Click  --- Bu locator tanımlanacak Left nav da, dıgerlerı tanımlanmıstı zaten
    }

    @When("User a Citizenship name as {string}   short name as {string}")
    public void userACitizenshipNameAsShortNameAs(String name, String shortName) {

        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", name);
        dc.findAndSend("shortName", shortName);    //   Bu locator tanımlanacak  Dialog da, dıgerlerı tanımlanmıstı zaten
        dc.findAndClick("saveButton");
    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {

        dc.findAndContainsText("alreadyExist","already exists");     //  Bu locator tanımlanacak Dialog da,
    }

    @And("Click on close button")
    public void clickOnCloseButton() {

        dc.findAndClick("closeDialog");    //  Bu locator tanımlanacak  Dialog da,
    }


    @When("User delete the {string}")
    public void userDeleteThe(String arananKelime) {

        dc.SearchAndDelete(arananKelime);
    }




}
