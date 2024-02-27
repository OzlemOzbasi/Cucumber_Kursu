package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
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


    // TODO:   ( Yeni bir Excel'e bütün raporu yazacak )
    //         Dosyanın varlıgını veya yoklugunu kontrol etmeyi Google dan bulunuz ( alttakı bu sekılde yapılır )
    //         Kendisine verilen     path, scenario, browserTipi, zaman parametreleri ile



  // asagıdakı metod ıle TODO da ıstedıgını yeni bir excel olusturarak yapıyoruz.
    public static void writeExcel (String path, Scenario scenario, String browserName, String time) throws IOException {

        File f = new File(path);


    if ( ! f.exists() ) {    //  exists : VARSA  demek  , başında ! olunca YOKSA demek

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sayfa1");
        Row newRow = sheet.createRow(0);

        Cell newCell = newRow.createCell(0);
        newCell.setCellValue(scenario.getName() );

        newCell = newRow.createCell(1);
        newCell.setCellValue(scenario.getStatus().toString() );

        newCell = newRow.createCell(2);
        newCell.setCellValue(browserName );

        newCell = newRow.createCell(3);
        newCell.setCellValue(time );



        try {
            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);

            workbook.close();         //  Hafıza boşaltıldı
            outputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    else
    {
        FileInputStream inputStream = null;     //  Bu komut okuma modunda açar
        Workbook workbook = null;

        try {
            inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getPhysicalNumberOfRows();     //  6 satır var   ( 0-5 )
        Row newRow = sheet.createRow(rowCount);             //   en son satırın altına açıldı


        Cell newCell = newRow.createCell(0);
        newCell.setCellValue(scenario.getName() );

        newCell = newRow.createCell(1);
        newCell.setCellValue(scenario.getStatus().toString() );

        newCell = newRow.createCell(2);
        newCell.setCellValue(browserName );

        newCell = newRow.createCell(3);
        newCell.setCellValue(time );



        try {
            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);

            workbook.close();         //  Hafıza boşaltıldı
            outputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
      }
    }




//  bu alttakı metod yanı main kısmını test için yaptık, yazdırıp konsolda gormek ıcın

    public static void main(String[] args) {


        ArrayList < ArrayList < String > >  tablo =
                getListData ( "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx" , "testCitizen" , 2 );


        System.out.println("tablo = " + tablo);


    }



}


/*    KONSOL CIKTISI :

[[ulkeleris11, umis1], [ulkeleris12, umis2], [ulkeleris13, umis3], [ulkeleris14, umis4], [ulkeleris15, umis5], [ulkeleris16, umis6], [ulkeleris17, umis7], [ulkeleris18, umis8]]


 */
