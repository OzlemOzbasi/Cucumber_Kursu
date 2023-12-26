package StepDefinitions;

import Utilities.GenelWebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {



    @Before
    public  void  before()
    {
        System.out.println("Senaryo başladı");
    }




    @After
    public  void  after(Scenario scenario)
    {

 // Hatanın nerede oldugunu zamanı ve ekran görüntüsü ile birlikte target ta  FailedScreenShots dosyası acarak goruntuyu oraya atıyor

        System.out.println("Senaryo Bitti");
        System.out.println("scenario sonucu= " + scenario.getStatus());
        System.out.println("scenario isFailed ?= " + scenario.isFailed());

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");



         if (scenario.isFailed() ){

             // klasöre
             TakesScreenshot screenshot = (TakesScreenshot) GenelWebDriver.getDriver();
             File ekranDosyasi = screenshot.getScreenshotAs(OutputType.FILE);


             try {

                 FileUtils.copyFile(ekranDosyasi,
                      new File("target/FailedScreenShots/" + scenario.getId() + date.format(formatter) + ".png") );

             } catch (IOException e) {

                 e.printStackTrace();
             }

         }




        //  Hatalı ise --- ekran görüntüsü al dicez
        GenelWebDriver . quitDriver();    //  acılan web sayfasını kapatmak ıcın yazdık
    }


}
