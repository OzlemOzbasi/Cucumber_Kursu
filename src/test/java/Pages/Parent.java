package Pages;

import Utilities.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Parent {    // her pom da ( page object modellerın ortak fonksıyonlarını almak ıcın ) kullanabılmek ıcın bu  class ı  actık


    public void sendKeysFunction(WebElement element, String value) {           //  3.Aşama

        waitUntilVisible(element);      // Element  gözükene kadar bekle
        scrollToElement(element);       // Elemente scroll yap
        element.clear();                // temizle
        element.sendKeys(value);        // değeri gönder
    }


    public void waitUntilVisible(WebElement element) {         // Element  gözükene kadar bekle

        WebDriverWait wait = new WebDriverWait(GenelWebDriver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void scrollToElement(WebElement element) {       // Elemente scroll yap

        JavascriptExecutor js = (JavascriptExecutor) GenelWebDriver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }



    public void clickFunction(WebElement element)
    {
        waitUntilClickable(element);    // tıklanabilir olana kadar bekle
        scrollToElement(element);       // elemente scroll yap
        element.click();                // click yap
    }



    public void waitUntilClickable(WebElement element) {

        WebDriverWait wait = new WebDriverWait(GenelWebDriver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }



    public void verifyContainsText(WebElement element, String text)
    {
        waitUntilVisible(element);                        // gözükene kadar bekle
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));
    }



    public void waitUntilLoading() {     // Bekleme bölümü yapmış olduk   , StaleElements hatasını gıdermek ıcın

        WebDriverWait wait = new WebDriverWait (GenelWebDriver.driver, Duration.ofSeconds(30));
        wait .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > * "), 0));
        //                                        > child demek   * hepsi demek , yani child ların hepsi sıfır olana kadar bekle


        // ınceledıgımız web sayfasının yanı Campus un  search tusuna basınca sayfanın en ustunde oluşan yükleme
        // çizgısının locator ını bulmus olduk ve bu locator ın çocuklarının hepsi sıfır olana kadar bekle dedik
    }





    public List<WebElement> waitVisibleListAllElement(List<WebElement> elementList) {

        WebDriverWait wait = new WebDriverWait(GenelWebDriver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        return elementList;
    }



}
