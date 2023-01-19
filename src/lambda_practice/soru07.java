package lambda_practice;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class soru07 {
    //// S1:1 den 30 kadar olan sayilari (30 dahil degil) 1 2 3 .... seklinde siralayalim
    public static void main(String[] args) {
        for (int i = 1; i < 30; i++) {
            System.out.print(i + " ");


        }
        System.out.println();
        ilk30(30);
        System.out.println();
        get20den100kadar(100);
        System.out.println();
        System.out.print(toplama(20, 30));
        System.out.println();
        System.out.println(ort(30, 40));
        System.out.println();
        System.out.println(sekizebolsayi(325, 465));
        System.out.println();
        sekizebolsayi1(325,468);
    }

    /// S1:1 den 30 kadar olan sayilari (30 dahil degil) 1 2 3 .... seklinde siralayalim
    public static void ilk30(int a) {
        IntStream.range(1, a).forEach(Utils::printInSmale);
    }

    //S2:  20 den 100 kadar olan sayilari (100 dahil ) 1 2 3 .... seklinde siralayalim (for loopsuz)
    public static void get20den100kadar(int a) {
        IntStream.rangeClosed(1, a).forEach(Utils::printInSmale);
    }

    //S3 Istenen iki deger(dahil) arasindaki sayilari toplayalim
    public static int toplama(int start, int end) {
        return IntStream.rangeClosed(start, end).sum();
    }

    //S4: 30 ile 40 arasindaki sayilarin (dahil) ortalamasini bulalim
    public static OptionalDouble ort(int a, int b) {
        return IntStream.rangeClosed(a, b).average();
    }

    //S5: 325 ile 468 arasinda 8 e bolunen kac sayi vardir?
    public static long sekizebolsayi(int bas, int bitis) {
        return IntStream.rangeClosed(bas, bitis).filter(t -> t % 8 == 0).count();

    }

    public static void sekizebolsayi1(int bas, int bitis) {
        IntStream.rangeClosed(bas, bitis).filter(t -> t % 8 == 0).forEach(Utils::printInSmale);
    }
    // S8: 7 ile 15 (dahil) arasindaki tek sayilarin carpimini bulalim
    public static void teksayibul(int a,int b) {
       return  IntStream.rangeClosed(a, b).filter(t -> t % 2 != 0).reduce()
    }

}