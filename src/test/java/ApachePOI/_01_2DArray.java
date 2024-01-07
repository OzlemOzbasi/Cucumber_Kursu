package ApachePOI;

public class _01_2DArray {
    public static void main(String[] args) {

        String[] [] zoo = { {"Aslan","1"}, {"Kaplan","2"}, {"Zebra","3","1"}, {"Fil","4"} };

        System.out.println("---------------------");
        System.out.println( zoo[2] [0]);               // Zebra
        System.out.println( zoo[2] [1]);              // 3
        System.out.println("---------------------");


        for (int i = 0; i < zoo.length; i++) {           // satır sayısını verir

            for (int j = 0; j < zoo[i].length; j++) {    //  i. satırın uzunlugunu verır

                System.out.print ( zoo[i][j] + "\t");   //  "\t"  yazdırırken    Aslan 1  arasında boşluk bırakmak ıcın

            }

            System.out.println();      // alt satıra gecmesı ıcın

        }

  //  List ne zaman kullanılır : Ne kadar eleman olacağı belli değilken , aslında ne kadar eleman ekleneceği belli değilken


    }
}
// ---------------------   Ekran cıktısı
// Zebra
// 3
// ---------------------
//     Aslan 1
//     Kaplan 2
//     Zebra 3 1
//     Fil 4