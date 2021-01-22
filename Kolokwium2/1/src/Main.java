//Filip Strózik 260377
import java.util.*;

class Lista {
    ArrayList<Ksiazka> lista;

    public Lista(){
        lista = new ArrayList<Ksiazka>();
    }

    public boolean wstaw(Ksiazka k){
        return lista.add(k);
    }

    public void wysywietlAfabetycznieWgAutorowmalejaco(){
        Collections.sort(lista, new Comparator<Ksiazka>() {
            @Override
            public int compare(Ksiazka o1, Ksiazka o2) {
                int wgnazwiska =  o1.nazwisko.compareTo(o2.nazwisko);
                if(wgnazwiska > 0) return -1;
                if(wgnazwiska < 0) return 1;
                return 0;
            }
        });
        int i=1;
        for (Ksiazka k:lista){
            System.out.println(i+" "+k);
            i++;
        }
    }

    public void wysywietlAfabetycznieWgTytulu(){
        Collections.sort(lista, new Comparator<Ksiazka>() {
            @Override
            public int compare(Ksiazka o1, Ksiazka o2) {
                return o1.tytul.compareTo(o2.tytul);
            }
        });
        int i=1;
        for (Ksiazka k:lista){
            System.out.println(i+" "+k);
            i++;
        }
    }

    public void wysiwtlenieKsiazekAutora(String nazw) {
        TreeSet<Ksiazka> temp = new TreeSet<>(lista);
        Iterator<Ksiazka> it = temp.iterator();
        int i=1;
        while (it.hasNext()) {
            Ksiazka k = it.next();
            if (k.nazwisko.equals(nazw)) {
                System.out.println(i+" "+k);
                i++;
            }
        }
    }

    public void wysiwtlenieAlfabetycznieAutorow() {
        TreeSet<String> temp = new TreeSet<String>();
        for(Ksiazka k :lista){
            temp.add(k.nazwisko+" "+k.imie);
        }
        ArrayList<String> t = new ArrayList<>(temp); //mozna tak zamienic
        Collections.sort(t, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        int i=1;
        for (String nazwa:t){
            System.out.println(i+" "+nazwa);
            i++;
        }
    }



}


class Ksiazka implements Comparable<Ksiazka>{
    String nazwisko;
    String imie;
    String tytul;

    Ksiazka(String n, String i,String t)
    {
        nazwisko=n;
        imie=i;
        tytul=t;
    }

    @Override
    public int compareTo(Ksiazka o) {
        int w_nazwiska;
        w_nazwiska = nazwisko.compareTo(o.nazwisko);
        if(w_nazwiska!=0){
            return w_nazwiska;
        }
        int w_imienia = imie.compareTo(o.imie);
        if(w_imienia!=0){
            return w_imienia;
        }
        return tytul.compareTo(o.tytul);

    }


    @Override
    public String toString() {
        return nazwisko +" "+imie+" "+tytul;
    }
}


public class Main {

    public static void main(String[] args) {
        Ksiazka k1 = new Ksiazka("Mickiewicz","Adam","Pan");
        Ksiazka k2 = new Ksiazka("Mickiewicz","Adam","Pan");
        Ksiazka k3 = new Ksiazka("Słowacki","Juliusz","Kordian");
        Ksiazka k4 = new Ksiazka("Mickiewicz","Adam","Dziady");
        Lista lista = new Lista();
        if(lista.wstaw(k1)) System.out.println("wstawiono do listy "+k1);
        if(lista.wstaw(k2)) System.out.println("wstawiono do listy "+k2);
        if(lista.wstaw(k3)) System.out.println("wstawiono do listy "+k3);
        if(lista.wstaw(k4)) System.out.println("wstawiono do listy "+k4);

        lista.wysywietlAfabetycznieWgAutorowmalejaco();
        System.out.println();
        lista.wysywietlAfabetycznieWgTytulu();
        System.out.println();
        lista.wysiwtlenieKsiazekAutora("Mickiewicz");
        System.out.println();
        lista.wysiwtlenieAlfabetycznieAutorow();
    }
}