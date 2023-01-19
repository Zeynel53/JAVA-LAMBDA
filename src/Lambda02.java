import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {
    public static void main(String[] args) {

        List<Integer>sayi= new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));

        ciftKarePrint(sayi);
        System.out.println();
        tekKupBirFazlaPrint(sayi);
        System.out.println();
        ciftElKarekokPrint(sayi);
        System.out.println();
        maxElBul(sayi);
        System.out.println();
        structuredMaxElBul(sayi);
        System.out.println();
        ciftElMaxPrint(sayi);
        System.out.println();
        elTopla(sayi);
        System.out.println();
        ciftCarp(sayi);
        System.out.println();
        minBul(sayi);
        System.out.println();
       minBul(sayi);
        System.out.println();
        besBuyukTekKucuk(sayi);
        System.out.println();
        ciftElKareKbPrint(sayi);



    }

    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKarePrint( List<Integer>sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).//akistaki cift sayilari filtreledim,4,2,6
                map(t->t*t).//16,4,36 -- stream icerisindeki elemanlari baska degerlere donusturur
                forEach(Lambda01::yazdir);
    }

    // Task 2: Functional Programming ile listin tek elemanlarinin
    // kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edi
    public static void tekKupBirFazlaPrint(List<Integer>sayi){
        sayi.stream().filter(t->t%2!=0).map(t->(t*t*t)+1).forEach(Lambda01::yazdir);

    }
         // Task-3 : Functional Programming ile listin cift elemanlarinin
        // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftElKarekokPrint(List<Integer>sayi){

        sayi.stream().filter(Lambda01::ciftBul).map(Math::sqrt).forEach(t->System.out.print(t+" "));
    }
    // Task-4 : list'in en buyuk elemanini yazdiriniz

   public static void maxElBul(List<Integer>sayi){
       Optional<Integer>maxSayi= sayi.
                               stream().
                                 reduce(Math::max);//eger benim resultim tek bir deger ise reduce terminal operatoru kullanilir
       System.out.println(maxSayi);
   }
   //structural yapi ile cozelim
   public static void  structuredMaxElBul(List<Integer> sayi){

       int max= Integer.MIN_VALUE;
       System.out.println("max = " + max);
       for (int i = 0; i <sayi.size() ; i++) {
           if (sayi.get(i)>max){
               max=sayi.get(i);
           }

       }
       System.out.println("En buyuk sayi : " +max);
   }
    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftElMaxPrint(List<Integer>sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Integer::max));//Integer::max metodu Integer::max a gore daha hizli calisir
    }
    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...

   public static void elTopla(List<Integer>sayi){
      int toplam=  sayi.stream().reduce(0,(a,b)->a+b);
       System.out.println("toplam="+toplam);
       /*
       *a ilk degerini her zaman atana degerden ilk parametreyi alir,bu oirnekte 0 oluyor



        */
   }
    //Task-7: List'teki tum cift elemanlarin carpimini yazdiriniz

        //1.yol
        public static void ciftCarp(List<Integer>sayi){
            System.out.println(sayi.
                    stream().
                    filter(Lambda01::ciftBul).
                    reduce(Math::multiplyExact));//method referance

            //2.yol
            System.out.println(sayi.
                    stream().
                    filter(Lambda01::ciftBul).
                    reduce(1, (a, b) -> (a * b)));//lambda expression
        }
        //Task-8: listeki elemanlari en kucugunu yaziniz
    public static void minBul(List<Integer>sayi){
        System.out.println(sayi.stream().reduce(Integer::min));

        //2.yol
        sayi.stream().reduce(Lambda02::byMiracMin);
    }

    public static int byMiracMin(int a, int b){
        return a<b ? a:b ;
    }
    //task 9: listeki 5  den buyuk en kucuk tek sayiyi print ediniz
    public static void besBuyukTekKucuk(List<Integer>sayi){

        System.out.println(sayi.stream().filter(a -> a > 5 && a % 2 == 1).reduce(Lambda02::byMiracMin));

    }
    //task-10: list in cift elemanlarinin karelerini kucuktun buyuge print ediniz

    public static void ciftElKareKbPrint(List<Integer>sayi){

        sayi.
                stream().//akisi baslattik
                filter(Lambda01::ciftBul).//akis icinde cift sayilari aldim
                map(t->t*t).//sayilarin karesi ile akis degisti
                sorted().//akis icindeki sayilari natural-order olarak siraladim
                forEach(Lambda01::yazdir);//akisdaki sayilari ekrana yazdim
    }

}
