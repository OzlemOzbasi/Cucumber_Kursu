package Utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelUtility {

    //  SORU :
    //          Kendisine verilen path deki  Excel'in  istenilen   sheet inde ki
    //          verilen kolon kadar sütunları  okuyup ArrayList formatında geri döndüren fonksiyonu yazınız.

    //  getListData ( "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx" , "testCitizen" , 2 );  0-2


    public static ArrayList< ArrayList< String > > getListData (String path, String sheetName, int columnCount){

        ArrayList < ArrayList < String > >  tablo = new ArrayList<>();


        Workbook workbook = null;       //   workbook  u  sheet ıcın  kullanabılmek ıcın try catch dısında tanımladık


        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);    // sheet ıcın  kullanabılmek ıcın try catch dısında tanımladık

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sayfa = workbook.getSheet(sheetName);


        for (int i = 0; i < sayfa.getPhysicalNumberOfRows(); i++) {  // Bütün satırları alacagımız ıcın bu sekılde yazdık
                                          // Yani (soruda 2 sütun istiyor) bütün satırların istenilen sayıda sütununu alacağız
            ArrayList <String> satirData = new ArrayList<>();

            for (int j = 0; j < columnCount; j++) {     // istenilen sayıda sütununu almış oluyoruz burada  columnCount

                satirData.add( sayfa.getRow(i). getCell(j). toString()  );

            }

            tablo.add(satirData);
        }



        return tablo;
    }





 /*

//  bu alttakı metod yanı main kısmını test için yaptık, yazdırıp konsolda gormek ıcın
    public static void main(String[] args) {


        ArrayList < ArrayList < String > >  tablo =
                getListData ( "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx" , "testCitizen" , 2 );


        System.out.println("tablo = " + tablo);


    }


  */


}


/*    KONSOL CIKTISI :

[[ulkeleris11, umis1], [ulkeleris12, umis2], [ulkeleris13, umis3], [ulkeleris14, umis4], [ulkeleris15, umis5], [ulkeleris16, umis6], [ulkeleris17, umis7], [ulkeleris18, umis8]]


 */
