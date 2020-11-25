class Firma {
    int max;
    Pracownik [] tabPracownikow;

    Firma (){
        tabPracownikow=new Pracownik[0];
        max=100;
        // na poczatku nie musi to byc tablica o 100 pracownikow, za kazdym
        // dodaniem pracownikow mozemy po prostu zwiekszac, tworzac wieksza o 1 kopie itd. Ale chyba o to
        //chodzilo w poleceniu.
    }

    public void przyjmijNowegoPracownika(Pracownik p){
        if(tabPracownikow.length<max){
            Pracownik [] temp = new Pracownik[tabPracownikow.length+1];
            for(int i=0;i<tabPracownikow.length;i++)
            {
                temp[i]=tabPracownikow[i];
            }
            temp[temp.length-1]=p;
            tabPracownikow=temp;
        }
    }

    public void zwolnij(String n){
        int pozycja=-1;
        Pracownik [] temp = new Pracownik[tabPracownikow.length-1];
        for(int i=0;i< tabPracownikow.length;i++){
            if(tabPracownikow[i].nazwisko.equals(n))
            {
                pozycja=i;
            }
        }
        if(pozycja==0){
            for(int i=1;i< tabPracownikow.length;i++){
                temp[i-1]=tabPracownikow[i];
            }
        }else if(pozycja>0 && pozycja< tabPracownikow.length-1){
            for(int i=0;i< pozycja;i++){
                temp[i]=tabPracownikow[i];
            }
            for(int i=pozycja+1;i< tabPracownikow.length;i++){
                temp[i-1]=tabPracownikow[i];
            }
        }else if(pozycja==tabPracownikow.length-1){
            for(int i=0;i< pozycja;i++){
                temp[i]=tabPracownikow[i];
            }
        }
        else{
            System.out.println("Nie można usunąć nieistniejacego pracownika");
        }
    }

    public Pracownik znajdz(String n){
        for(int i=0;i<tabPracownikow.length;i++){
            if(tabPracownikow[i].nazwisko.equals(n))
            {
                return tabPracownikow[i];
            }
        }
        return null;
    }

    public int ileZatrudnionychNR() {
        int counter=0;
        for(int i=0;i< tabPracownikow.length;i++){
            if(tabPracownikow[i]!=null && tabPracownikow[i].czyNierobotnik())
            {
                counter++;
            }
        }
        return counter;
    }

    public int ileZatrudnionychR() {
        int counter=0;
        for(int i=0;i< tabPracownikow.length;i++){
            if(tabPracownikow[i]!=null && (!tabPracownikow[i].czyNierobotnik()))
            {
                counter++;
            }
        }
        return counter;
    }

    public double sumaWyplat(){
        double suma=0;
        for(Pracownik pracownik:tabPracownikow){
            suma+=pracownik.placa();
        }
        return suma;
    }

    void swap(int a, int b){
        Pracownik temp = tabPracownikow[b];
        tabPracownikow[b]=tabPracownikow[a];
        tabPracownikow[a]=temp;
    }

    boolean porownajNazwiska(String n1, String n2){
        int n = n1.compareTo(n2);
            if(n1.compareTo(n2)>0){ // <0 jak n1 jest "pierwszy" =0 jak są takie same >0 jak n2 jest"pierwsze"
                // i potrzeba zamienic
                return true;
            }
            else
                return false;

    }
    void sortNazwiska(){
        for(int i=0; i< tabPracownikow.length-1;i++){
            boolean zmiana =false;
            for(int j=0;j< tabPracownikow.length-i-1;j++){

                if(porownajNazwiska(tabPracownikow[j].nazwisko,tabPracownikow[j+1].nazwisko)){
                    swap(j,j+1);
                    zmiana=true;
                }
            }
            if(!zmiana){
                break;
            }
        }
    }

    public void wydruk(){
        Pracownik [] temp = tabPracownikow;
        sortNazwiska();
        for(Pracownik pracownik:tabPracownikow){
            System.out.println(pracownik);
        }
        tabPracownikow=temp;
    }
}


abstract class Pracownik{
    String nazwisko;
    double czesc_etatu;
    public Pracownik(String n,double cz_et){
        nazwisko=n;
        czesc_etatu=cz_et;
    }

    abstract boolean czyNierobotnik();

    abstract double placa();

    public String toString(){
        return nazwisko +" "+ placa();
    }
}


class Robotnik extends Pracownik{
    int limitGodzin=40; //dla wszystkich pracowników limit taki sam
    int liczbaGodzin;
    double stawkaGodzinowa;
    public Robotnik(String n,double cz_et,int liczba_godzin,double stawka_godzinowa){
        super(n,cz_et);
        liczbaGodzin=liczba_godzin;
        stawkaGodzinowa=stawka_godzinowa;
        limitGodzin=(int)czesc_etatu*limitGodzin;
    }

    public double placa(){
        double suma;
        if(liczbaGodzin>=limitGodzin){
            suma =(liczbaGodzin-limitGodzin)*stawkaGodzinowa*1.5 + limitGodzin*stawkaGodzinowa;
        }
        else{
            suma = liczbaGodzin*stawkaGodzinowa;
        }
        return suma;
    }

    @Override
    boolean czyNierobotnik() {
        return false;
    }
}


class NieRobotnik extends Pracownik{
    double placa_podst =1350.0;
    int procentPremii;
    public NieRobotnik(String n,double cz_et,int procent_premii){
        super(n,cz_et);
        procentPremii=procent_premii;
    }

    public double placa(){
        return placa_podst*czesc_etatu+procentPremii*0.01*placa_podst;
    }

    @Override
    boolean czyNierobotnik() {
        return true;
    }
}


public class Main {


    public static void main(String[] args) {

        Firma f = new Firma();
        Robotnik r1 = new Robotnik("Kowalski",0.5,40,25.6);
        NieRobotnik r2 = new NieRobotnik("Nowak",0.5,70);

        f.przyjmijNowegoPracownika(r1);
        f.przyjmijNowegoPracownika(r2);

        System.out.println(f.znajdz("Kowalski"));
        System.out.println(f.znajdz("Nowak"));

        if(r1.czyNierobotnik()){
            System.out.println(r1.nazwisko+" jest Nierobotnikiem");
        }
        else {
            System.out.println(r1.nazwisko+" jest Robotnikiem");
        }

        if(f.tabPracownikow[1].czyNierobotnik()){
            System.out.println(f.tabPracownikow[1].nazwisko+" jest Nierobotnikiem");
        }
        else {
            System.out.println(f.tabPracownikow[1].nazwisko+" jest Robotnikiem");
        }

        f.zwolnij("Kowalski");
        System.out.println("Liczba Pracownikow: "+f.tabPracownikow.length);

//        for(Pracownik pracownik:f.tabPracownikow){
//            if(pracownik==null){
//                System.out.println("wolne miejsce");
//            }
//            else
//            {
//                System.out.println(pracownik);
//            }
//        }

        f.przyjmijNowegoPracownika(new NieRobotnik("Strozik",1.0,50));
        f.przyjmijNowegoPracownika(new NieRobotnik("Adamowicz",1.0,50));
        f.przyjmijNowegoPracownika(new NieRobotnik("Wojtowicz",1.0,50));
        f.przyjmijNowegoPracownika(new NieRobotnik("Wojtacha",0.6,70));


        for(Pracownik pracownik:f.tabPracownikow){
            if(pracownik==null){
                System.out.println("wolne miejsce");
            }
            else
            {
                System.out.println(pracownik);
            }
        }
        System.out.println("Liczba Pracownikow: "+f.tabPracownikow.length);
        System.out.println("Liczba Nierobotnikow: "+f.ileZatrudnionychNR());
        System.out.println("Liczba Robotnikow: "+f.ileZatrudnionychR());
        System.out.println("Suma wypłat w firmie: "+f.sumaWyplat());
        f.wydruk();



    }
}
