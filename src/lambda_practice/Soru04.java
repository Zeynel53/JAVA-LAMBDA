package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Soru04 {
    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("trileçe", "havucDilim", "güvec", "kokorec",
                "küşleme", "arabAşı", "waffle", "künefe", "güvec"));
        alfByHrfTek(menu);
        System.out.println();
        krtrSayTersSrliTksiz(menu);
        System.out.println();
        krtSayKckBykPrint(menu);
        System.out.println();
        yedidenAzOlma(menu);
        System.out.println();
        wIleBaslama(menu);
        System.out.println();
        xIleBiten(menu);
        System.out.println();
        krtrSayEnByk(menu);
        System.out.println();
        ilkElHrc(menu);

    }
    // Task -1 : List elemanlarini alfabetik buyuk harf ve  tekrarsiz print ediniz.

    public static void alfByHrfTek(List<String> menu) {
        menu.
                stream().
                map(String::toUpperCase).
                sorted().
                distinct().
                forEach(t -> System.out.print(t + " "));
    }

    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void krtrSayTersSrliTksiz(List<String> menu) {
        menu.stream().map(String::length).sorted(Comparator.reverseOrder()).distinct().forEach(Soru02::yazdir);
    }

    // Task-3 : List elemanlarini, character sayisina gore kckten byk e gore print ediniz tekrarsiz..
    public static void krtSayKckBykPrint(List<String> menu) {
        menu.stream().sorted(Comparator.comparing(String::length)).distinct().forEach(Soru02::yazdir);
    }

    // Task-4 : List elemanlarinin hepsinin karakter sayisinin 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void yedidenAzOlma(List<String> menu) {
        System.out.println(menu.stream().allMatch(t -> t.length() <= 7) ? "list elemani 7 ve 7 daha az harften olusuyor" :
                "7 den daha fazla harfe sahiptir");
    }

    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static void wIleBaslama(List<String> menu) {
        System.out.println(menu.stream().
                noneMatch(t -> t.startsWith("w")) ? "w ile yemek ismi mi olur" : "w ile yemek icet ettik");
    }
    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı var mı kontrol ediniz.

    public static void xIleBiten(List<String> menu) {
        System.out.println(menu.stream().
                anyMatch(t -> t.endsWith("x")) ? "x ile biten elemani var" : "x ile biten elemani yok");

    }
    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.

    public static void krtrSayEnByk(List<String> menu) {
        Stream<String> sonIsim = menu.stream().sorted(Comparator.comparing(t -> t.toString().length()).
                reversed()).limit(1);

        System.out.println(Arrays.toString(sonIsim.toArray()));
    }

// Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.

    public static void ilkElHrc(List<String> menu){
        menu.stream().
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))).
                skip(1).
                forEach(Soru02::yazdir);
    }
}
