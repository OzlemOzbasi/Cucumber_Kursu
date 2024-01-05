package Runners;


import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;

@CucumberOptions(

        tags = "@RegressionTest",
        features = {"src/test/java/FeatureFiles/" },
        glue = {"StepDefinitions"},

        plugin = { "html:target//cucumber-reports.html" }

)

// Bu alttakını https://www.programsbuzz.com/article/cucumber-testng-extent-report-using-adapter sayfasından ekledık Report ıcın

@Listeners({ExtentITestListenerClassAdapter.class})

public class _07_TestRunnerExtendReport extends AbstractTestNGCucumberTests {

// Bu alttakını  https://www.toolsqa.com/selenium-cucumber-framework/cucumber-extent-report/ sayfasından ekledık
// Target altındaki Report ıcın , raporun sağ alt kosesıne ıstedıgımız sekılde bılgı eklemek ıcın

    @AfterClass
    public static void writeExtentReport() {
    //    ExtentService.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
        ExtentService.getInstance().setSystemInfo("User Name", "Deniz Kaynak");
        ExtentService.getInstance().setSystemInfo("Application Name", "Campus");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name").toString());
        ExtentService.getInstance().setSystemInfo("Department", "QA");
        ExtentService.getInstance().setSystemInfo("Ek Satır", "Açıklama");

    }


}
