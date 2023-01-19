package lambda_practice;

import java.util.*;
import java.util.stream.Collectors;

public class Soru05 {

     /*
TASK :
fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
 */

 /*
TASK :
fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
 */

    public static void main(String[] args) {

        Universite u01 = new Universite("bogazici", "matematik", 571, 93);
        Universite u02 = new Universite("istanbul tk", "matematik", 600, 81);
        Universite u03 = new Universite("istanbul", "hukuk", 1400, 71);
        Universite u04 = new Universite("marmara", "bilgisayar muh", 571, 77);
        Universite u05 = new Universite("odtu", "gemi muh", 333, 74);

        List<Universite> unv = new ArrayList<>(Arrays.asList(u01, u02, u03, u04, u05));
        System.out.println(butunUnivNotOrt(unv));
        System.out.println();
        System.out.println(matBlmVarMi(unv));
        System.out.println();
        System.out.println(unuBykKckSirala(unv));
        System.out.println(matBolSayPrint(unv));
        System.out.println();
        System.out.println(ogrSayBesYuzNotOrt(unv));
        System.out.println();
        System.out.println(ogrSayNotOrtEnKck(unv));
    }

    //task 01: butun unuivlerin not ortlamalarinin 74 den buyuk oldugunu kontrol eden

    public static boolean butunUnivNotOrt(List<Universite> unv ){
        return unv.stream().allMatch(t->t.getNotOrt()>74);
    }
        //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz

    public static boolean matBlmVarMi(List<Universite> unv){
        return unv.stream().anyMatch(t->t.getBolum().toLowerCase().contains("mat"));
    }
        //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz
    public static List<Universite> unuBykKckSirala(List<Universite> unv){
        return unv.stream().sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).collect(Collectors.toList());
    }
        //task-04 -->"matematik" bolumlerinin sayisini  print ediniz.
    public static int matBolSayPrint(List<Universite> unv){
        return (int) unv.stream().filter(t->t.getBolum().contains("mat")).count();
    }
    //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz

    public static OptionalInt ogrSayBesYuzNotOrt(List<Universite> unv){
        return unv.stream().filter(t->t.getOgrSayisi()>550).mapToInt(Universite::getNotOrt).max();
    }
    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt ogrSayNotOrtEnKck(List<Universite> unv){
        return unv.stream().filter(t->t.getOgrSayisi()<1050).mapToInt(Universite::getNotOrt).min();
    }
}