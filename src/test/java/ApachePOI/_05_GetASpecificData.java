package ApachePOI;


/*
SORU :

    Verilen Excel deki password bilgisini bir metod aracılığı ile bularak yazdırınız,
    Yani metoda "password"  kelimesi gönderilecek, dönen değer password un kendisi olacak.
    src/test/java/ApachePOI/resources/LoginData.xlsx

 */

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class _05_GetASpecificData {
    public static void main(String[] args) {

        System.out.print("Aranacak Kelime= ");
        Scanner oku = new Scanner(System.in);
        String arananKelime = oku.next();

        String donenSonuc = bul (arananKelime);

        System.out.println("donenSonuc = " + donenSonuc);



    }

   // Hem okuma hem yazma modu aynı anda calısmıyor
  //  Okuma modu acılıyor okuma yapılıyor, yazma modu acılıyor yazma yapılıyor

    public static String bul (String arananKelime)
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

           Row row = sheet.getRow(i);
           Cell cell = row.getCell(0);  // alttakı for da cell i  1 den baslattık cunku sıfırı buraya yazmıstık

           if ( cell.toString().equalsIgnoreCase(arananKelime)) {

               int hucreSayisi = row.getPhysicalNumberOfCells();

               for (int j = 1; j < hucreSayisi; j++) {

               donecek = donecek + row.getCell(j) + " ";      //   donecek += row.getCell(j)+" ";   de aynı sey demek

        }
     }

  }
        return  donecek;

    }


}

/*   KONSOL CIKTISI :

Aranacak Kelime= password
donenSonuc = MyPassIsHere

yada

Aranacak Kelime= address
donenSonuc = 123main 21A Irealand Dublin


 */