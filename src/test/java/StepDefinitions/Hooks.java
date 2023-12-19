package StepDefinitions;

import Utilities.GenelWebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {



    @Before
    public  void  before()
    {
        System.out.println("Senaryo başladı");
    }




    @After
    public  void  after()
    {

        //  Hatalı ise --- ekran görüntüsü al dicez
        GenelWebDriver . quitDriver();    //  acılan web sayfasını kapatmak ıcın yazdık
    }


}
