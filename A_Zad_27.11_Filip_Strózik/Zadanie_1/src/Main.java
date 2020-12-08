//Zadabnie 27.11.2020
//Wariant z Hierachią
//Filip Strózik 260377

abstract class Dyplom{
    Wlasciciel wlasciciel;
    long unikat_nr_dyplomu;
    String data;
    public Dyplom(Wlasciciel w, long nr, String d){
        wlasciciel=w;
        unikat_nr_dyplomu=nr;
        data=d;
    }

    public String toString(){
        return (wlasciciel+"Unikatowy nr dyplomu: " + unikat_nr_dyplomu+" data wystawienia: "+data);
    }


    public boolean equals(Dyplom d){
        if(this.wlasciciel.equals(d.wlasciciel)&& this.data.equals(d.data) && this.unikat_nr_dyplomu==d.unikat_nr_dyplomu){
            return true;
        }
        else
        {
            return false;
        }
    }

}

class DyplomUznania extends Dyplom{
    String tytul;

    public DyplomUznania(Wlasciciel w, long nr, String d,String t) {
        super(w, nr, d);
        tytul=t;
    }

    public String toString(){
        return super.toString() +" tytuł: "+tytul;
    }

}

class DyplomInzyniera extends Dyplom{
    String specjalnosc;

    public DyplomInzyniera(Wlasciciel w, long nr, String d,String spec) {
        super(w, nr, d);
        specjalnosc=spec;
    }

    public String toString(){
        return super.toString() +" spec: "+specjalnosc;
    }
}


class Wlasciciel{
    long pesel;
    public Wlasciciel(long p){
        pesel=p;
    }

    public boolean equals(Wlasciciel w){
        if(this.pesel == w.pesel){
            return true;
        }
        else
        {
            return false;
        }
    }
    public String toString(){
        return ("pesel wlasciciela: "+pesel+" ");
    }
}

class RejestrDyplomow{
        Dyplom [] tab_dyplomow;
        int max;

        public RejestrDyplomow(){
            tab_dyplomow= new Dyplom[0];
            max=3;//d
        }

        public int findDyplom(Dyplom d){
            for(int i=0;i< tab_dyplomow.length;i++){
                if(tab_dyplomow[i].equals(d)){
                    return i;
                }
            }
            return -1;
        }

        public void dopiszDyplom(Dyplom d){
            if(tab_dyplomow.length<max){ //warunek czy osiagnieto limit
                if(findDyplom(d)!=-1){
                    System.out.println("dyplom juz jest w rejestrze!");//odpowiedz na stan
                }
                else{
                    Dyplom [] temp = new Dyplom[tab_dyplomow.length+1];//przekopiowanie
                    for(int i=0;i< tab_dyplomow.length;i++){
                        temp[i]=tab_dyplomow[i];
                    }
                    temp[tab_dyplomow.length]=d;//dodanie nowego
                    tab_dyplomow=temp;
                }
            }
            else{
                System.out.println("Osiągnieto maksymalną ilosc Dyplomow!");
            }
        }

        public String wypiszDyplomyWl(Wlasciciel w){
            String s=("Dyplomy Wlasciciela o numerze: "+ w.pesel+"\n");
            for(int i=0;i< tab_dyplomow.length;i++) {
                if (tab_dyplomow[i].wlasciciel.equals(w)) {
                    s = s + " " + tab_dyplomow[i] + "\n";
                }
            }
            return s;
        }

        public String wypiszDaneWlascicielaDyplomuONumerze(long nr){
            String s=("Dane wlasciciela Dyplomu o numerze: "+ nr +"\n");
            for(int i=0;i< tab_dyplomow.length;i++) {
                if (tab_dyplomow[i].unikat_nr_dyplomu==nr) {
                    s = s +tab_dyplomow[i].wlasciciel;
                }
            }
            return s;
        }

        public String toString(){//niech zwraca tekst
            String s="Rejestr Dyplomow: \n";
            for(Dyplom dyplom:tab_dyplomow){
                s = s + dyplom+ "\n";
            }
            return s;
        }
}



public class Main {

    public static void main(String[] args) {
        RejestrDyplomow r = new RejestrDyplomow();
        Wlasciciel w1 = new Wlasciciel(03122);
        Wlasciciel w2 = new Wlasciciel(12345);
        Dyplom d1 = new DyplomInzyniera(w1,1 ,"01.11","Infromatyka");
        Dyplom d2 = new DyplomInzyniera(w1,1 ,"01.11","Infromatyka");
        Dyplom d3 = new DyplomUznania(w2,2 ,"11.11","Matematyka");
        r.dopiszDyplom(d1);//dopisuje Dyplom inzyniera do rejestru
        System.out.println(r);
        r.dopiszDyplom(d2); //proba wpisania tego samego dyplomu!
        System.out.println(r);
        r.dopiszDyplom(d3);
        System.out.println(r);
        System.out.println(r.wypiszDyplomyWl(w2));
        System.out.println(r.wypiszDaneWlascicielaDyplomuONumerze(1));
        r.dopiszDyplom(new DyplomUznania(w2,3,"01.01","Historia"));
        System.out.println(r);
        r.dopiszDyplom(new DyplomUznania(w1,4,"31.11","Logika"));//osiagniecie limitu dyplomow
        System.out.println(r.wypiszDyplomyWl(w2));
    }
}
