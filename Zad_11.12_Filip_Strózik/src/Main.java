public class Main {

    public static void main(String[] args) {
        Student s1 = new Student("Jan","Kowalski", 1,6.0);
        Student s2 = new Student("Filip","Strozik",2,5.0);

        Student [] tablica_studentow = {s1,s2};
        GrupaStud gs = new GrupaStud("Infromatyka W8",tablica_studentow);

        gs.DodajStudenta(new Student("Kasia","Haras",3,4.50));

        Wykaz w1 = new Wykaz(gs);
        System.out.println(w1);
        System.out.println();

        Towar t1 = new Towar("procesor",1,30.99);
        Towar t2 = new Towar("ram",3,10.99);
        Towar t3 = new Towar("karta GPU",2,50.99);

        Towar [] tablica_towarow = {t1,t2,t3};
        Zakup zakup = new Zakup("Sprzedarz w dniu : 01.12.2020", tablica_towarow);
        zakup.DodajTowar(new Towar("iMac",3,399.99));

        Wykaz w2 = new Wykaz(zakup);
        System.out.println(w2);

    }
}
