public class Uczen {
    long nr_indeksu;
    String nazwisko,imie;
    double ocena;

    public Uczen(long nr_indeksu,String nazwisko,String imie,double ocena){
        this.nr_indeksu=nr_indeksu;
        this.nazwisko=nazwisko;
        this.imie=imie;
        this.ocena=ocena;
    }

    public String toString(){
        return ("numer indeksu: "+nr_indeksu+" nazwisko: "+nazwisko+" imie: "+imie+" ocena: "+ocena);
    }
}
