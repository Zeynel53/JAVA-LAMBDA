package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Soru02 {
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(5,6,5,6,47,48,49,20,53));

        eleman(sayi);
        System.out.println();
        el(sayi);
        System.out.println();
        tek(sayi);
        System.out.println();
        ciftler(sayi);
        System.out.println();
        bes(sayi);

    }



    //TASK  : "functional Programming" kullanarak list elemanlarını aynı satirda aralarında bosluk olacak sekilde print ediniz.

    public static void eleman(List<Integer> rakam){
        rakam.stream().forEach(t-> System.out.print(t+" "));


    }
    public static void el(List<Integer> rakam){
        rakam.stream().forEach(System.out::print);
    }



    public static boolean tekYazdir(int b){

        return b%2!=0;
    }
    //tek sayilari yazdir

    public static void tek(List<Integer> rakam){

        rakam.stream().filter(Soru02::tekYazdir).forEach(Soru02::yazdir);
    }

    public static void yazdir(int a){
        System.out.print(a+ " ");
    }

    public static boolean cift(int c){
        return c%2==0;
    }
    //ciftleri yazdir

    public static void ciftler(List<Integer> rakam){
        rakam.stream().filter(Soru02::cift).forEach(Soru02::yazdir);
    }
    public static boolean besIleBolunen(int d){

        return d%5==0;

    }
    public static void bes(List<Integer> rakam){

        rakam.stream().filter(Soru02::besIleBolunen).forEach(Soru02::yazdir);
    }

    public static void yazdir(Double aDouble) {
    }

    public static void yazdir(String s) {
        System.out.print(s+" ");
    }
}
