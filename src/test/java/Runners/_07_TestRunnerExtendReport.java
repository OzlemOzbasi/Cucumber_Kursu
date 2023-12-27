package Runners;


import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@CucumberOptions(

        tags = "@RegressionTest",
        features = {"src/test/java/FeatureFiles/" },
        glue = {"StepDefinitions"},

        plugin = { "html:target//cucumber-reports.html" }

)



@Listeners({ExtentITestListenerClassAdapter.class})

public class _07_TestRunnerExtendReport extends AbstractTestNGCucumberTests {
}
