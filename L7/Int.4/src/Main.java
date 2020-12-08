import Figury.*;
import Zlecenia.*;

public class Main {

    public static void main(String[] args) {
        Prostokot p1= new Prostokot(10,5);
        System.out.println("Pole:");
        System.out.println(p1.oblicz_pole());
        System.out.println("Obwod:");
        System.out.println(p1.oblicz_obwod());
//        Kolo k1 = new Kolo(10);
//        System.out.println("Pole:");
//        System.out.println(k1.oblicz_pole());
//        System.out.println("Obwod:");
//        System.out.println(k1.oblicz_obwod());
//        Kwadrat kw1 = new Kwadrat(20);
//        System.out.println("Pole:");
//        System.out.println(kw1.oblicz_pole());
//        System.out.println("Obwod:");
//        System.out.println(kw1.oblicz_obwod());

//        fz1.dopiszFigure(new Kolo(10));
//        System.out.println("Pole:");
//        System.out.println(fz1.oblicz_pole());
//        System.out.println("Obwod:");
//        System.out.println(fz1.oblicz_obwod());
//
        Zlecenie z1 = new ZlecenieFigury(p1);
        System.out.println("koszt Ciecia:");
        System.out.println(z1.kosztCiecia());
        System.out.println("Koszt Materialu");
        System.out.println(z1.kosztMaterialu());

        FiguraZlozona fz1 = new FiguraZlozona(new Figura[]{new Kwadrat(10)});
        System.out.println("Pole:");
        System.out.println(fz1.oblicz_pole());
        System.out.println("Obwod:");
        System.out.println(fz1.oblicz_obwod());

        ZlecenieFiguryZlozonej zfz1  =new ZlecenieFiguryZlozonej(new Figura[]{fz1});
        zfz1.dopiszZlecenieFigury(new Kolo(10));
        System.out.println("koszt Ciecia:");
        System.out.println(zfz1.kosztCiecia());
        System.out.println("Koszt Materialu");
        System.out.println(zfz1.kosztMaterialu());

    }
}
