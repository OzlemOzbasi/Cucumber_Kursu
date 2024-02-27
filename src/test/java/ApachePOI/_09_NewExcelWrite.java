package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _09_NewExcelWrite {
    public static void main(String[] args) throws IOException {

        // Solda resource kısmında hiç olmayan yeni bir EXCEL oluşturma

       // Hafızada yeni workbook oluştur, sonra sheet oluştur, sonra row oluştur, sonra cell oluştur.

        XSSFWorkbook workbook = new XSSFWorkbook();      //   XSSF ---- sanal demek
        XSSFSheet sheet = workbook.createSheet("Sayfa1");


        //  HAFIZADA oluşturma ve yazma işlemleri yapılıyor

        Row yeniSatir = sheet.createRow(0);           //   0.yerde   satır oluşturuldu
        Cell yeniHucre = yeniSatir.createCell(0);     //   yeni satırda ilk hücre oluşturuldu
        yeniHucre.setCellValue("Hello World :)) ");     //    bilgi yazıldı


        for (int i = 1; i < 10 ; i++) {       //  Cell yeniHucre = yeniSatir.createCell(0);
                                              // üstte cell 0 dan basladıgı ıcın burada 1 den baslattık

            yeniSatir.createCell(i).setCellValue(i);
        }


        // YAZMA işlemini YAZMA modunda açıp öyle yapacağız

        String yeniExcelPath = "src/test/java/ApachePOI/resource/YeniExcel.xlsx";

        FileOutputStream outputStream = new FileOutputStream(yeniExcelPath);
        workbook.write(outputStream);
        workbook.close();               //  Hafıza boşaltıldı
        outputStream.close();

        System.out.println("İşlem Tamamlandı...");


    }
}
