public class Towar {
    String nazwa;
    int ilosc;
    double cena;
    double wartosc;

    public Towar(String n, int i, double c){
        nazwa=n;
        ilosc=i;
        cena=c;
        wartosc = cena*ilosc;
    }
}
