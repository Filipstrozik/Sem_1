//Filip Strózik 260377
class Pracownik {
    String nazwisko;
    String imie;
    ObliczWyplate sposob;
    double pensja;
    double premia;
    double godziny;
    double stawka;

    public Pracownik(){
        this.nazwisko = null;
    }

    public Pracownik(String nazwisko, String imie){
        this.nazwisko = nazwisko;
        this.imie = imie;
//        this.sposob = sposob;
    }
    public String toString(){
        String s = nazwisko +" "+imie+" "+WykonajSposob();
        return s;
    }

    public void UstawSposob(ObliczWyplate o){
        sposob=o;
    }

    public double WykonajSposob(){
        return sposob.sposobNaWyplate(this);
    }

}



// KLASY PODRZEDNE --------------------------------
class PracEtat extends Pracownik {
    double pensja;
    double premia;
    public PracEtat(String nazwisko, String imie, double pensja, double premia) {
        super(nazwisko, imie);
        sposob = new sposobWynagracaniaEtat();
        this.pensja = pensja;
        this.premia = premia;
    }


    public String toString(){
        String dane;
        dane = super.toString();
        return dane;
    }
}


class PracUmowa extends Pracownik {
    double godziny;
    double stawka;
    public PracUmowa(String nazwisko, String imie, double godziny, double stawka){
        super(nazwisko, imie);
        this.sposob = new sposobWynagracaniaUmowa();
        this.godziny = godziny;
        this.stawka = stawka;
    }


    public String toString(){
        String dane;
        dane = super.toString();
        return dane;
    }
}


interface ObliczWyplate{
    public double sposobNaWyplate(Pracownik pracownik);
}




class sposobWynagracaniaEtat implements ObliczWyplate{

    public double sposobNaWyplate(Pracownik pracownik) {
        PracEtat p = (PracEtat) pracownik;
        double w;
        w = (1 + p.premia/100)*p.pensja;
        return w;
    }
}


class sposobWynagracaniaUmowa implements ObliczWyplate{

    public double sposobNaWyplate(Pracownik pracownik) {
        PracUmowa p = (PracUmowa) pracownik;
        double w;
        w = p.godziny*p.stawka;
        return w;
    }
}



public class Main {

    public static void main(String[] args) {
        Pracownik p = new PracEtat("Kowalski","Jan", 2000,13);// jednak trzebabyło zrobic jedna Klase Pracownik bez
        //hierarchii bonie mozna zmienic sposobu dla Pracownika Etat.
        System.out.println(p.WykonajSposob());
        p.UstawSposob(new sposobWynagracaniaUmowa());
        System.out.println(p.WykonajSposob());
    }
}
