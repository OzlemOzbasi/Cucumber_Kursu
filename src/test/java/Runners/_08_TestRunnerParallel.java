package Runners;


import Utilities.GenelWebDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(

        tags = "@Regression",       //  Hangi senaryolarda bu etiket varsa o senaryolar çalıstırılacak
        features = {"src/test/java/FeatureFiles/" },
        glue = {"StepDefinitions"},
        plugin = { "html:target//cucumber-reports.html" }

)

public class _08_TestRunnerParallel extends AbstractTestNGCucumberTests {


    @BeforeClass
    @Parameters("browser")
    public void beforeClass (String browser)
    {
        // Burada browser set edilecek

        GenelWebDriver.threadBrowserName.set(browser);    //  Bu thread e browserName set edildi

    }



}
