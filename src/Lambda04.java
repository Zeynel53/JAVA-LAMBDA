import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
    /*
TASK :
fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
 */

    public static void main(String[] args) {

        Universite u01 = new Universite("bogazici","matematik",571,93);
        Universite u02 = new Universite("istanbul tk","matematik",600,81);
        Universite u03 = new Universite("istanbul","hukuk",1400,71);
        Universite u04 = new Universite("marmara","bilgisayar muh",571,77);
        Universite u05 = new Universite("odtu","gemi muh",333,74);

        List<Universite>unv = new ArrayList<>(Arrays.asList(u01,u02,u03,u04,u05));

        System.out.println(notOrt74BykUnv(unv));
        System.out.println();
        System.out.println(matBolumVarMi(unv));
        System.out.println();
        System.out.println(uniBykKckSirala(unv));
        System.out.println();
        System.out.println(matBolSayPrint(unv));
        System.out.println();
        System.out.println(ogrcSayisi550BykMaxNotOrt(unv));
        System.out.println();
        System.out.println(ogrcSayisi1050BykMaxNotOrt(unv));
    }
//task 01: butun unuivlerin not ortlamalarinin 74 den buyuk oldugunu kontrol eden
    public static boolean notOrt74BykUnv(List<Universite>unv ){

        return unv.stream().allMatch(t->t.getNotOrt()>74);
    }

    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz
    public static boolean matBolumVarMi(List<Universite>unv ){
        return  unv.
                stream().//akis saglandi
                anyMatch(t->t.getBolum().//objelerin bolum isimleri alindi
                        toLowerCase().//kucuk harfe cevrildi
                        contains("mat"));//mat kelimesivar mi
    }

    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz

    public static List<Universite> uniBykKckSirala(List<Universite>unv){

   return  unv.
           stream().
           sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).//ogr sysna gore tersten yazildi
           collect(Collectors.toList());//steram i list yapsina dondurdu


    }
    //task-04 -->"matematik" bolumlerinin sayisini  print ediniz.

    public static int matBolSayPrint(List<Universite>unv){
      return  (int) unv.
              stream().
              filter(t->t.getBolum().contains("mat")).
              count();
    }
    //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz
    public static OptionalInt ogrcSayisi550BykMaxNotOrt(List<Universite>unv){
  return unv.stream().
          filter(t->t.getOgrSayisi()>550).mapToInt(t->t.getNotOrt()).max();
    }
    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.

    public static OptionalInt ogrcSayisi1050BykMaxNotOrt(List<Universite>unv){
     return    unv.stream().
             filter(t->t.getOgrSayisi()<1050).
             mapToInt(t->t.getNotOrt()).
             min();
    }



}
