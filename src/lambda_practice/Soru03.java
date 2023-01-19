package lambda_practice;

import java.util.*;
import java.util.stream.Stream;

public class Soru03 {
    public static void main(String[] args) {
        List<Integer> yeni = new ArrayList<>(Arrays.asList(25, 35, 24, 9, 78, 56, 12, 94));

        altmisKucukCift(yeni);
        System.out.println();
        altmisBuyukTek(yeni);
        System.out.println();
        ciftKareAl(yeni);
        System.out.println();
        kupBirTekFazlasi(yeni);
        System.out.println();
        karekokCift(yeni);
        System.out.println();
        enBykEl(yeni);
        System.out.println();
        ciftEnBykEl(yeni);
        System.out.println();
        tumElTopPrint(yeni);
        System.out.println();
        tumCiftElCarp(yeni);
        System.out.println();
        tumCiftElCarp1(yeni);
        System.out.println();
        enKckEl(yeni);
        System.out.println();
        besBykEnKckTekSayi(yeni);
        System.out.println();
        ciftKareKbSortPrint(yeni);

    }


    //60 dan kucuk sayilari ve cift olanlari yazdiriniz

    public static void altmisKucukCift(List<Integer> yeni) {

        yeni.stream().filter(t -> t % 2 == 0 && t < 60).forEach(Soru02::yazdir);
    }

    //60 dan buyuk veya tek sayilri yaziniz

    public static void altmisBuyukTek(List<Integer> yeni) {

        yeni.stream().filter(t -> t % 2 != 0 || t > 60).forEach(Soru02::yazdir);

    }
    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKareAl(List<Integer> yeni) {
        yeni.stream().filter(Soru02::cift).map(t -> t * t).forEach(Soru02::yazdir);
    }
// Task 2: Functional Programming ile listin tek elemanlarinin
    // kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print ediniz

    public static void kupBirTekFazlasi(List<Integer> yeni) {
        yeni.stream().filter(t -> t % 2 != 0).map(t -> (t * t * t) + 1).forEach(Soru02::yazdir);
    }
    // Task-3 : Functional Programming ile listin cift elemanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void karekokCift(List<Integer> yeni) {

        yeni.stream().filter(Soru02::cift).map(Math::sqrt).forEach(t -> System.out.println(t + " "));
    }

    // Task-4 : list'in en buyuk elemanini yazdiriniz

    public static void enBykEl(List<Integer> yeni) {
        Optional<Integer> enyeni = yeni.stream().reduce(Math::max);
        System.out.println(enyeni);
    }

    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftEnBykEl(List<Integer> yeni) {
        System.out.println(yeni.stream().filter(Soru02::cift).map(t -> t * t).reduce(Integer::max));
    }

    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...
    public static void tumElTopPrint(List<Integer> yeni) {
        int toplam = yeni.stream().reduce(0, (e, g) -> e + g);

        System.out.println("toplam = " + toplam);
    }

    //Task-7: List'teki tum cift elemanlarin carpimini yazdiriniz
    //1.yol//lambda expression
    public static void tumCiftElCarp(List<Integer> yeni) {
        int carpma = yeni.stream().filter(Soru02::cift).reduce(1, (a, b) -> a * b);
        System.out.println("carpma = " + carpma);
    }

    //2.yol//
    public static void tumCiftElCarp1(List<Integer> yeni) {
        System.out.println(yeni.stream().filter(Soru02::cift).reduce(Math::multiplyExact));//method referance

    }
    //Task-8: listeki elemanlari en kucugunu yaziniz
    public static void enKckEl(List<Integer> yeni){

        System.out.println(yeni.stream().reduce(Integer::min));
    }
    public static int zeynel(int a, int b){
        return (a<b) ? a : b;
    }
    //task 9: listeki 5  den buyuk en kucuk tek sayiyi print ediniz
    public static void besBykEnKckTekSayi(List<Integer> yeni){
        System.out.println(yeni.stream().filter(t -> (t > 5) && (t % 2 != 0)).reduce(Soru03::zeynel));
    }
    //task-10: list in cift elemanlarinin karelerini kucuktun buyuge print ediniz

    public static void ciftKareKbSortPrint(List<Integer> yeni){
        yeni.stream().filter(Soru02::cift).map(t->t*t).sorted().forEach(Soru02::yazdir);
    }
}