import java.util.Iterator;
import java.util.TreeSet;

class Lista {
    TreeSet<Ksiazka> lista;

    public Lista(){
        lista = new TreeSet<Ksiazka>();
    }

    public boolean wstaw(Ksiazka k){
        return lista.add(k);
    }

    public void wysywietl_ksiazki_autora(String nazw){
        Iterator<Ksiazka> it = lista.iterator();
        while(it.hasNext()){
            Ksiazka k = it.next();
            if(k.nazwisko.equals(nazw)){
                System.out.println(k);
            }
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


        lista.wysywietl_ksiazki_autora("Mickiewicz");
        lista.wysywietl_ksiazki_autora("Słowacki");

    }
}
