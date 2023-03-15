package StepDefinitions;

import io.cucumber.java.en.*;     //  bunun sonuna  *  ( yıldız ) ısaretını koyunca  asagıda kırmızı olan   Given  When  Then  duzelıyor

public class _01_LoginSteps {   https://test.mersys.io/        username: turkeyts
                                                          password: TechnoStudy123


    @Given("Navigate to basqar")
    public void navigate_to_basqar() {


    }


    @When("Enter username and password and click login button")
    public void enter_username_and_password_and_click_login_button() {
        System.out.println("Merhaba Gherkin");
    }


    @Then("User should login successfully")
    public void user_should_login_successfully() {
        System.out.println("Merhaba Maven");
    }

}
