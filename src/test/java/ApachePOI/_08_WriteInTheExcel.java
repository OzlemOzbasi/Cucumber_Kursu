package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_WriteInTheExcel {
    public static void main(String[] args) throws IOException {

    // Var olan bir Excel'e  YAZMA işlemi

        String path = "src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream = new FileInputStream(path);     //  Bu komut okuma modunda açar
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("Sayfa1");


        //  HAFIZADA oluşturma ve yazma işlemleri yapılıyor

        Row yeniSatir = sheet.createRow(0);           //   0.yerde   satır oluşturuldu
        Cell yeniHucre = yeniSatir.createCell(0);     //   yeni satırda ilk hücre oluşturuldu
        yeniHucre.setCellValue("Hello World :)) ");     //    bilgi yazıldı


        for (int i = 1; i < 10 ; i++) {      //  Cell yeniHucre = yeniSatir.createCell(0);
                                             // üstte cell 0 dan basladıgı ıcın burada 1 den baslattık

            yeniSatir.createCell(i).setCellValue(i);
        }


        // Sıra KAYDETMEYE geldi, buraya kadar bütün bilgiler hafızada, yani herşey WORKBOOK da

        inputStream.close();     // Okuma modunu kapattık, çünkü yazma modunda açmamız gerekiyor



        // YAZMA işlemini YAZMA modunda açıp öyle yapacağız

        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();               //  Hafıza boşaltıldı
        outputStream.close();

        System.out.println("İşlem Tamamlandı...");


    }
}
