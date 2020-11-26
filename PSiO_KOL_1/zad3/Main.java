//Strózik Filip
//260377

class Samochod{
    String marka;
    double pojemnosc;
    Wlasiciel wlasiciel;

    public Samochod(String m, double p, Wlasiciel w){
        marka=m;
        pojemnosc=p;
        wlasiciel=w;
    }

    public String toString(){
        return (marka+" "+pojemnosc+" "+wlasiciel);
    }

    public boolean equals(Samochod s){
        if(marka==s.marka && pojemnosc==s.pojemnosc && wlasiciel.equals(s.wlasiciel)){
            return true;
        }
        else
            return false;
    }
}

class Wlasiciel{
    String nazwisko;
    String imie;

    public Wlasiciel(String n, String i){
        nazwisko=n;
        imie=i;
    }

    public String toString(){
        return (nazwisko+" "+imie);
    }

    public boolean equals(Wlasiciel w){
        if(nazwisko==w.nazwisko && imie==w.imie){
            return true;
        }
        else
            return false;
    }
}



class Tab_sam {
    int ilesam;
    Samochod [] t;

    public Tab_sam(){
        ilesam=0;
        t= new Samochod[10];
    }

    public void wstawSam(Samochod s){
        t[ilesam]=s;
        ilesam++;
    }

    public void wyswietlsamochody(){
        for(int i=0; i<ilesam;i++){
            System.out.println(t[i]);
        }
    }
    public void wyswietlsamWlasciciela(Wlasiciel w){
        for(int i=0; i<ilesam;i++){
            if(t[i].wlasiciel.equals(w))
            {
                System.out.println(t[i]);
            }
        }
    }



}


public class Main {

    public static void main(String[] args) {
	    Tab_sam ts = new Tab_sam();
	    Wlasiciel w1 = new Wlasiciel("Kowalski","Jan");
        Wlasiciel w2 = new Wlasiciel("Kowicz","Adam");
	    ts.wstawSam(new Samochod("opel",3.0,w1));
        ts.wstawSam(new Samochod("Benz",5.0,w1));
        ts.wstawSam(new Samochod("Toyota",2.0,w2));
        ts.wyswietlsamochody();
        System.out.println();
        ts.wyswietlsamWlasciciela(w1);

        System.out.println();
        ts.wyswietlsamWlasciciela(w2);
    }
}
