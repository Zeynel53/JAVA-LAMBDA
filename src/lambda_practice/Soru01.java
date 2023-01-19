package lambda_practice;

import java.util.ArrayList;
import java.util.List;

public class Soru01 {
    public static void main(String[] args) {

        //example 1: Verılen bır lıstekı elemanaları ayni sirada olarak yazınız
        //      [2,3,2,5]  === [2,3,5]

        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(3);
        a.add(2);
        a.add(2);
        a.add(5);

        printElStructured(a);
        System.out.println();
        printElFunctional(a);
        System.out.println();
        printElFunctional1(a);
        System.out.println();
        printElFunctional2(a);
        System.out.println();
        printElFunctional3(a);
        System.out.println();
        printElFunctional4(a);

    }

    public static void printElStructured(List<Integer> a) {
        for (Integer w : a) {
            System.out.print(w + " ");

        }
    }

    public static void printElFunctional(List<Integer> a) {

        a.stream().forEach(w -> System.out.print(w + " "));


    }//sadece cift sayilari yazdirin
    public static void printElFunctional1(List<Integer> a) {

        a.stream().forEach(System.out::print);//method referenca//sayilar bitisik cikti


    }//kendimiz bir method yazalim

    public static void yazdir(int a){
        System.out.print(a+" ");
    }
    public static void printElFunctional2(List<Integer> a) {
        a.stream().forEach(Soru01::yazdir);
    }
   // functional Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void printElFunctional3(List<Integer> a) {
        a.stream().filter(t->t%2==0).forEach(Soru01::yazdir);
    }

    //tek sayilari yazdirin
    public static void printElFunctional4(List<Integer>a){
        a.stream().filter(t->t%2!=0).forEach(Soru01::yazdir);
    }


}