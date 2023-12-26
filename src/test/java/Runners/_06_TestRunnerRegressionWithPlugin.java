package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        tags = "@RegressionTest",
        features = {"src/test/java/FeatureFiles/" },
        glue = {"StepDefinitions"},

        plugin = { "html:target//cucumber-reports.html" }    // hata ile ılgılı rapor vermesı ıcın yazıldı , rapor target a eklenıyor

    //  mac için   plugin = { "html:target/cucumber-reports.html" }

)

public class _06_TestRunnerRegressionWithPlugin extends AbstractTestNGCucumberTests {
}
