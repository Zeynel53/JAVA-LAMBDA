import lambda_practice.Soru02;

import java.util.stream.IntStream;

public class Lambda05 {

    public static void main(String[] args) {


        System.out.println(topla(5));
        System.out.println();
        System.out.println(toplaCincix(5));
        System.out.println();
        System.out.println(ciftTamSayiToplami(5));
        System.out.println();
        System.out.println(ciftSayi(4));
        System.out.println();
        System.out.println(ciftSayi1(4));
        System.out.println();
        System.out.println(tekTopla(5));
        System.out.println();
        ikininIlkXKuvvetPrint(3);
        System.out.println();
        istenilenSayi(3,2);
        System.out.println();
        System.out.println(istenenSayiFaktoriyel(5));
        System.out.println();


    }

        //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil)
        // tamsayilari toplayan bir program create ediniz

        //Structured
    public static int topla(int x){
        int toplam=0;
        for (int i = 0; i <=x ; i++) {

            toplam+=i;

        }
        return toplam;
    }
    //Functional

    public static int toplaCincix(int x){
        return IntStream.//int degerlerde bir akis saglar
                range(1,x+1).//range(a,b)-->a dab b ye kadar(b dahil degil) int degerler akisa alindi
                sum();//akistan gelen degerler toplandi
    }

        //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int ciftTamSayiToplami(int x){
        return IntStream.
                rangeClosed(1,x).//BURADA HER IKI DEGER DAHIL
                filter(Soru02::cift).
                sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    //1.YOL
    public static int ciftSayi(int x){
        return IntStream.
                rangeClosed(1,x*2).
                filter(Soru02::cift).sum();
    }

    //2.YOL
    public static int ciftSayi1(int x){

      return IntStream.
              iterate(2,t->t+2).//2 den sonsuza kadar akisa alir
              limit(x).
              sum();
    }
    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.

    public static int tekTopla(int x){
        return IntStream.iterate(1,t->t+2).limit(x).sum();
    }
            //TASK 05 --> 2'nin ilk pozitift x kuvvetini ekrana yazdiran programi  create ediniz
    public static void ikininIlkXKuvvetPrint(int x){

        IntStream.
                iterate(2,t->t*2).//iterasyon icin sartimizi yazdik
                limit(x).//x degeri ile sifirladik
                forEach(Soru02::yazdir);
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create edini
    public static void istenilenSayi(int istenenSayi,int x){

        IntStream.
                iterate(istenenSayi,t->t*istenenSayi).
                limit(x).
                forEach(Soru02::yazdir);

    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz
    public static int istenenSayiFaktoriyel(int x){
        return IntStream.
                rangeClosed(1,x).
                reduce(1,(t,u)->t*u);


    }

}
