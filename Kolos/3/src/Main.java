import java.util.ArrayList;

class ListaPoj {
    ArrayList<Pojazd> lista;

    public ListaPoj(){
        lista = new ArrayList<Pojazd>();
    }

    public void dodaj(Pojazd p){
        lista.add(p);
    }


    public void wyswietlswitch(int p){
        if(p==0){
            for (Pojazd pojazd: lista){
                System.out.println(pojazd);
            }
        }
        else if(p==1){
            for (Pojazd pojazd: lista){
                if(pojazd instanceof SamOs){
                    System.out.println(pojazd);
                }
            }
        }
        else if(p==2){
            for (Pojazd pojazd: lista){
                if(pojazd instanceof SamCie){
                    System.out.println(pojazd);
                }
            }
        }
        else {
            System.out.println("zly przelacznik");
        }
    }

    public void wyswietlPojazdyWlasciciela(String nazw){
        for (Pojazd pojazd: lista){
            if(pojazd.wlasciciel.nazwisko.equals(nazw)){
                System.out.println(pojazd);
            }
        }
    }

    public void wyswietlPojazdyKoloru(String kol){
        for (Pojazd pojazd: lista){
            if(pojazd instanceof SamOs){
                SamOs tp = (SamOs)pojazd;
                if(tp.kolor.equals(kol)){
                    System.out.println(tp);//lub pojazd
                }
            }
        }
    }

    public void wyswietlDaneWlsc(long nr){
        for (Pojazd pojazd: lista){
            if(pojazd.nr_rej==nr){
                System.out.println(pojazd.wlasciciel);
                break;
            }
        }
    }


}





abstract class Pojazd{
    protected Wlasciciel wlasciciel;
    protected double pojemnosc;
    protected long nr_rej;
    public Pojazd(Wlasciciel w, double poj,long nr){
        wlasciciel=w;
        pojemnosc=poj;
        nr_rej=nr;
    }

    @Override
    public String toString() {
        return wlasciciel+" "+pojemnosc+" "+nr_rej;
    }
}


class SamOs extends Pojazd{
    String kolor;
    public SamOs(Wlasciciel w, double poj, long nr,String k) {
        super(w, poj, nr);
        kolor=k;
    }

    @Override
    public String toString() {
        return super.toString()+" "+kolor;
    }
}

class SamCie extends Pojazd{
    double ladownosc;
    public SamCie(Wlasciciel w, double poj, long nr,double l) {
        super(w, poj, nr);
        ladownosc = l;
    }

    @Override
    public String toString() {
        return super.toString()+" "+ladownosc;
    }
}



class Wlasciciel{
    String nazwisko;
    String imie;
    public Wlasciciel(String n,String i){
        nazwisko=n;
        imie=i;
    }

    public String toString() {
        return nazwisko+" "+imie;
    }
}

public class Main {

    public static void main(String[] args) {
        Wlasciciel w1 = new Wlasciciel("Nowak", "Marek");
        Wlasciciel w2 = new Wlasciciel("Kowalski", "Jan");
	    SamOs s1 = new SamOs(w1,5.0,123456,"Czerwony");
        SamOs s2 = new SamOs(w2,2.0,123457,"Czarny");
        SamCie s3 = new SamCie(w1,2.5,123458,3.8);
        ListaPoj l = new ListaPoj();
        l.dodaj(s1);
        l.dodaj(s2);
        l.dodaj(s3);
        l.wyswietlswitch(0);
        System.out.println();
        l.wyswietlswitch(1);
        System.out.println();
        l.wyswietlswitch(2);
        System.out.println();
        l.wyswietlPojazdyWlasciciela("Nowak");
        System.out.println();
        l.wyswietlPojazdyKoloru("Czarny");
        System.out.println();
        l.wyswietlDaneWlsc(123456);

    }
}
