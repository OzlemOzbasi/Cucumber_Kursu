package Runners;


import Utilities.GenelWebDriver;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


@CucumberOptions(

        tags = "@Regression",       //  Hangi senaryolarda bu etiket varsa o senaryolar çalıstırılacak
        features = {"src/test/java/FeatureFiles/" },
        glue = {"StepDefinitions"},
        plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"}   // master report için


)

public class _08_TestRunnerParallel_MasterReport extends AbstractTestNGCucumberTests {


    @BeforeClass (alwaysRun = true)  // bazı java versiyon hataları için ekledi hoca
    @Parameters("browser")
    public void beforeClass (String browser)
    {
        // Burada browser set edilecek

        GenelWebDriver.threadBrowserName.set(browser);    //  Bu thread e browserName set edildi

    }

}
