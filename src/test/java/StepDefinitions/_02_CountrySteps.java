package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

public class _02_CountrySteps {


    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Navigate to country page")
    public void navigateToCountryPage() {
        ln.findAndClick("setupOne");      // Setup Click
        ln.findAndClick("parameters");    // Parameters Click
        ln.findAndClick("countries");     // Countries Click
    }



    @When("Create a country")
    public void createACountry() {

        // Country ıcın delete calısmayanlar ıcın bu alttakı 2 String i yazdık
        String randomGenName = RandomStringUtils.randomAlphabetic(8);  // Her calıstırmada farklı ulke ve code vermesı ıcın yazdık
        String randomGenCode = RandomStringUtils.randomNumeric(4);


        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", randomGenName);
        dc.findAndSend("codeInput", randomGenCode);
        dc.findAndClick("saveButton");
    }



    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {

        dc.findAndContainsText("successMessage","success");
    }

    @When("Create a country name as {string}  code as  {string}")
    public void createACountryNameAsCodeAs(String name, String code) {

        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", name);
        dc.findAndSend("codeInput", code);
        dc.findAndClick("saveButton");

    }
}
