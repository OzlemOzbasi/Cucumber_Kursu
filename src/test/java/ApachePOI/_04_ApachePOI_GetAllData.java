package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class _04_ApachePOI_GetAllData {
    public static void main(String[] args) throws IOException {


        String path = "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";


        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook .getSheet("Sayfa1");


     //  Bütün dataları almak için tüm satırları almak lazım
     //  Çalışma sayfasındaki toplam satır sayısını veriyor alttaki

        int satirSayisi = sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < satirSayisi ; i++) {

          Row satir = sheet. getRow(i);                              //  i.satır alındı
          int hucreSayisi = satir. getPhysicalNumberOfCells();      // bu satırdaki toplam hücre sayısı alındı

          for (int j = 0; j < hucreSayisi ; j++) {               //  i.satırdaki hücre sayısı kadar dönecek
             Cell hucre = satir. getCell(j);                   //  bu satırdaki sıradaki hücreyi aldık

             System.out.print(hucre+ " ");

            }

            System.out.println();

        }




    }
}


/*

Lion 3.0
Tiger 2.0 White Tiger 4.0
Zebra 4.0
Bear 8.0



End

  */