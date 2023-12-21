package StepDefinitions;

import Pages.DialogContent;
import Pages.FormContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;

public class _05_DatatableSteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    FormContent fc = new FormContent();


    @And("Click on the element in the left Nav")
    public void clickOnTheElementInTheLeftNav(DataTable elements) {

        List<String> listElement = elements.asList(String.class);
        //  Buradaki <String>  ile  (String.class) aynı seye denk geliyor ama parantez içine sadece String kabul etmediği için
        //  (String.class) olarak yazıyoruz  DataTable da

        for (int i = 0; i < listElement.size(); i++) {
    //        System.out.println("listElement = " + listElement.get(i));
            ln.findAndClick(listElement.get(i));

        }
    }


    @And("Click on the element in the Dialog")
    public void clickOnTheElementInTheDialog(DataTable elements) {

        List<String> listElement = elements.asList(String.class);

        for (int i = 0; i < listElement.size(); i++) {
            //        System.out.println("listElement = " + listElement.get(i));
            dc.findAndClick(listElement.get(i));

        }
    }

    @And("User sending the keys in Dialog Content")
    public void userSendingTheKeysInDialogContent(DataTable elements) {

        List<List<String>> listElement = elements.asLists(String.class);

        for (int i = 0; i < listElement.size(); i++) {

            //                nameInput             ,         ozlemCountry1           yaz
            //                codeInput             ,         12345                   yaz
            dc.findAndSend(listElement.get(i).get(0), listElement.get(i).get(1));

            // Listin ilk elemanına (webelement adı), ikinci elemanı yani değeri gönder

        }
    }


    @And("User delete item from Dialog")
    public void userDeleteItemFromDialog(DataTable elements) {

        List<String> listElement = elements.asList(String.class);

        for (int i = 0; i < listElement.size(); i++) {
            //        System.out.println("listElement = " + listElement.get(i));
            dc.SearchAndDelete(listElement.get(i));

        }
    }


    @And("Click on the element in the Form Content")
    public void clickOnTheElementInTheFormContent(DataTable elements) {

        List<String> listElement = elements.asList(String.class);

        for (int i = 0; i < listElement.size(); i++) {
            //        System.out.println("listElement = " + listElement.get(i));
            fc.findAndClick(listElement.get(i));

        }
    }


}
