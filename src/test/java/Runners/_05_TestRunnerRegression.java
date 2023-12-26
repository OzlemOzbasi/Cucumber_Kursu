package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(   // or olduğunda herhangi bir tanesi varsa çalıştırır.
                   // and olduğunda her ikisininde senaryoda tag olarak olan senaryoları çalıstırır.

        tags = "@RegressionTest",       //  Hangi senaryolarda bu etiket varsa o senaryolar çalıstırılacak
    //  tags = "@RegressionTest or @SmokeTest",    bu sekılde de baska bır testte ekleyebılırız
        features = {"src/test/java/FeatureFiles/" },
        glue = {"StepDefinitions"}

)

public class _05_TestRunnerRegression extends AbstractTestNGCucumberTests {
}  // Browser tipi vermek için, rapora ek parametre eklemek için sonra bu kısmı kullanacağız
