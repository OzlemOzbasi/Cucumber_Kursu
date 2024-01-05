package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

 // SmokeTest : Hızlı test, yazılan kodların hızlıca kontrolü,
 //             yazılan kodların ana hatları yani önemli kısımları çalışıyor mu dıye kontrol edılır
//              Yani ilk görünüm ( çok çalıştırılmaz genellikle
//              - yeni bir özellik eklendiğinde
//              - ya da hatalar var ve bu hatalar giderildikten sonra yapılır )
//  Tester , manuel testing ile defect var ise onları Jira da oluşturur. Kendine verilen süre içerisinde aynı zamanda bu bölümün
//           automation kodlarını yazar ve Regression Test grubuna ekler.
// Regression Test :  Release  günü gelmeden 2 veya 3 gün önce Regressiın testi yapılır.
//                  - yeni eklenen bölüm eski bölümler ile hatasız çalışıyormu
//                  - Diğer bölümleri etkiledi mi ,
//     Başarısız oldu ise : Manuel olarak test eder o bölümü ve gerçekten hata var ise defect taksı açar.
//     Başarılı oldu ise  : UAT testine geçilir. User acceptance test yani Kullanıcı Kabul Testi.
//                         Business taraf, Müşteri taraf test eder.
//                         Bu testte Başarısız ise : Manuel olarak test eder o bölümü ve gerçekten hata var ise defect taksı açar.
//                                   Başarılı ise  : Release günü bekleniyor. Production environment -- Buraya kadar EST ENVIRONMENT
//   Bundan sonrası     PRODUCTION ENV.  Yani Release Günü - Production Sahnesi
//   Saat 6 da : Mesai bitince   --- son sürüm PRODUCTION a yüklenir  ( Business taraf incelesim diye )
//   Business taraf tüm testlerini CANLI ortamda yapar. ONAY verirse güncelleme kalır.
//                                                      ONAY VERMEZSE, hata çıkarsa önceki sürüme geri dönülür.
//  GENELDE AYDA 2 KERE BU DÖNGÜ DEVAM EDER , firmadan firmaya değişebilir.


@CucumberOptions (

        tags = "@SmokeTest",       //  Hangi senaryolarda bu etiket varsa o senaryolar çalıstırılacak
        features = {"src/test/java/FeatureFiles/" },
        glue = {"StepDefinitions"},
        plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"}
    // plugin kısmını --- buradan  https://www.programsbuzz.com/article/masterthought-cucumber-reporting    rapor için ekledık  -->
// Hangı testi calıstırmak yanı rapordakı ozellıgı hangı raporda gormek ıstıyorsak plugin kısmını oraya eklıyoruz

)

public class _04_TestRunnerSmoke extends AbstractTestNGCucumberTests {

}
