package ApachePOI;

/*
SORU :

    Bir önceki soruda kullanıcıdan bu sefer sütun numarası isteyiniz
    Ve o sütundaki bütün bilgileri yazdırınız.

 */

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _07_Soru {
    public static void main(String[] args) {

        System.out.print("İstenen Sütun= ");
        Scanner oku = new Scanner(System.in);
        int sutun = oku.nextInt();

        String donenSonuc = bul (sutun);
        System.out.println("donenSonuc = " + donenSonuc);
    }


    public static String bul (int sutun)
    {
        String donecek="";

        String path = "src/test/java/ApachePOI/resource/LoginDataExcel2.xlsx";


        Workbook workbook = null;       //   workbook  u  sheet ıcın  kullanabılmek ıcın try catch dısında tanımladık

        try {

            FileInputStream inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);  // sheet ıcın  kullanabılmek ıcın try catch dısında tanımladık

        } catch (IOException e) {        //  IOException  : FileInputStream ve create ın altı kırmızı oluyordu sag clıck,
            //   more action  ile try catch e aldık , bu  IOException ikisinide kapsıyor
            throw new RuntimeException(e);
        }


        Sheet sheet = workbook.getSheetAt(0);    //  .getSheet("Login");  bu sekılde de yazılabılır


        int satirSayisi = sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < satirSayisi; i++) {  // UST SATIRI SILIP satirSayisi YERINE  sheet.getPhysicalNumberOfRows();  DA YAZILABILIR

            Row row = sheet.getRow(i);   //  row = satır
                                                                    // sütun sayısı istenen sütun sayısından büyükse ( null lar ıcın )
           if (sheet.getRow(i).getPhysicalNumberOfCells() > sutun)  // bos olan satırlarda run yapınca null gözükmemesi için
            donecek = donecek + row.getCell(sutun)+"\n";            //   donecek += row.getCell(sutun);   de aynı sey demek
                                                                    //  hatta buradakı row yerıne  sheet.getRow(i);  de yazabılırız
        }                                                           //  "\n"   kelımeler arasında boşluk bırakmak ıcın yazdık

        return  donecek;

    }

}

/*    KONSOL CIKTISI

İstenen Sütun= 0
donenSonuc = Username
Password
Address
Zipcode
City
State

yada

İstenen Sütun= 2       ---- bos olan yerlerde null gözükmemesi için
donenSonuc = null
null
21A Irealand
12345.0
null
null
null


 */