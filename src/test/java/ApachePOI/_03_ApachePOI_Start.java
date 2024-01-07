package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _03_ApachePOI_Start {
    public static void main(String[] args) throws IOException {


        //  Dosyanın yolu yani pathi alındı

        String path = "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";
   //   String path = "src\\test\\java\\ApachePOI\\resource\\ApacheExcel2.xlsx";     üstteki ile aynı sey bazı pc ler boyle gosterebılır


    //  Java Dosya okuma işlemcisine dosyanın yolunu veriyoruz, Böylece program ile dosya arasında bağlantı oluştu
       FileInputStream dosyaOkumaBaglantisi = new FileInputStream(path);


    //  Dosya okuma işlemcisi üzerinden Çalışma Kitabını alıyoruz
    //  hafızada  Workbook u  alıp  oluşturdu  yani  yeniden  bir  oluşturma  yok
        Workbook  calismaKitabi = WorkbookFactory.create(dosyaOkumaBaglantisi);


    // İstediğim isimdeki çalışma sayfasını alıyorum
        Sheet calismaSayfasi = calismaKitabi .getSheet("Sayfa1");
 //     Sheet calismaSayfasi2 = calismaKitabi .getSheetAt(0);            bu sekılde de yazılabılır


     //  İstenen satırı alıyorum
         Row satir = calismaSayfasi .getRow(0);

     //  İstenen satırdaki istenen hücre alınıyor
         Cell hucre = satir .getCell(0);


        System.out.println("hucre = " + hucre);     //  çıktısı --->  hucre = Lion





    }
}
