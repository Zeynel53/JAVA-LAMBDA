package lambdasorular;

import lambda_practice.Soru02;
import lambda_practice.Universite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class LmbdSrlr01 {

    //-->Görev-1
//1-)Konsolda 3'ten 10'a kadar tam sayılar nasıl yazdırılır
//2-)3 ile 10 Arası Tam Sayıların Toplamı Nasıl Bulunur?
//3-)9 faktöriyel nasıl bulunur
//4-)6'dan 100'e kadar olan tek tam sayıların toplamı nasıl bulunur?
//5-)İlk 5 çift sayının çarpımı nasıl bulunur
//6-)4'ten büyük 6 tek tam sayının çarpımı nasıl bulunur?

    public static void main(String[] args) {

        uctenOnaKadar();
        System.out.println();
        System.out.println(ucdenOnaKadarTop());
        System.out.println();
        System.out.println(faftoriyel(9));
        System.out.println();
        System.out.println(altidanYuzeTek());
        System.out.println();
        ilkBesSayiCarp(5);


        Universite u01 = new Universite("bogazici","matematik",571,93);
        Universite u02 = new Universite("istanbul tk","matematik",600,81);
        Universite u03 = new Universite("istanbul","hukuk",1400,71);
        Universite u04 = new Universite("marmara","bilgisayar muh",571,77);
        Universite u05 = new Universite("odtu","gemi muh",333,74);

        List<Universite>unv = new ArrayList<>(Arrays.asList(u01,u02,u03,u04,u05));


    }
    //1-)Konsolda 3'ten 10'a kadar tam sayılar nasıl yazdırılır
    public static void uctenOnaKadar(){

        IntStream.rangeClosed(3,10).forEach(Soru02::yazdir);

    }
    //2-)3 ile 10 Arası Tam Sayıların Toplamı Nasıl Bulunur?
    public static int ucdenOnaKadarTop(){
        return IntStream.rangeClosed(3,10).sum();
    }
    //3-)9 faktöriyel nasıl bulunur
    public static int faftoriyel(int a){
        return IntStream.rangeClosed(1,9).reduce(1,(t,u)->t*u);
    }
    //4-)6'dan 100'e kadar olan tek tam sayıların toplamı nasıl bulunur?
    public static int altidanYuzeTek(){
        return IntStream.rangeClosed(6,100).filter(t->t%2!=0).sum();
    }
    //5-)İlk 5 çift sayının çarpımı nasıl bulunur
    public static void ilkBesSayiCarp(int a){
         IntStream.
                 iterate(2,t->t*2).
                 limit(a).
                 forEach(Soru02::yazdir);
    }


        //S7: uzunlugu 3 ile 7 arası olan veya a ile biten elemanlardan yeni bir liste olustur
        //S8:list elemanlarını uzunluklarına ve ikinci harflerine göre benzersiz sıralayıp yazdırın
        // S9: uzunlugu 4 ve 8 olanlar haric bir liste olusturunuz
        //S10: List elemanlarını son harfe göre sıralayıp, son 3 elemanı yazdırın


}


