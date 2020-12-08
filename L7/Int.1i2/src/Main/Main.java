package Main;

import Interfejs.Funkcja;
import Interfejs.Wielomian;
import Interfejs.xsin;

public class Main {

    public static void main(String[] args) {
//        Funkcja f1 = new xsin();    //f1
//
//        Tabela txsinx = new Tabela(new xsin(),-10,10,4);
//
//        System.out.println(txsinx);
//
//        Funkcja wiel = new Wielomian(1,1,1,1);
//        Tabela t2 = new Tabela(wiel,-10,10,10);
//        System.out.println(t2);
        //Program zawiera zad Int.1 oraz Int.2
        Funkcja wiel = new Wielomian(1,6,10,0);
        Tabela t1 = new Tabela(wiel,-10,10,10);
        System.out.println(t1);

        ZbiorMetod zbm = new ZbiorMetod(wiel);
        System.out.println("pochodna w xo=0, h=0.5");
        System.out.println(zbm.pochodna(0,0.5));
        System.out.println("Miejse zerowe w przedziale (-10,10)");
        System.out.println(zbm.miejsceZerowewPrzedziale(-10,10));
        System.out.println("ekstremum w przedziale (-4,2)");
        System.out.println(zbm.ekstremum(-4,-2));
        System.out.println("ektremum w przedziale (-2,5)");
        System.out.println(zbm.ekstremum(-2,5));
        System.out.println("przegiecie funkcji w przedziale (-20,20)");
        System.out.println(zbm.przegiecie(-20,20));
        System.out.println("wartosc całki funkcji w przedziale (-2,0) z n= 1000");
        System.out.println(zbm.calka(10000,-2,0));
    }
}
