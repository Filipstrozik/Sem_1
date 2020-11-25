public class Main {

    public static void main(String[] args) {
	    Uczen u1 = new Uczen(100001,"Nowak","Jan",5.0);
        Uczen u2 = new Uczen(100002,"Kamien","Kacper",4.0);
        Uczen u3 = new Uczen(100003,"Mysiak","Anna",6.0);
        Uczen u4 = new Uczen(100004,"Wrzos","Oskar",6.0);
        Uczen u5 = new Uczen(100005,"Kowalewicz","Mateusz",3.0);
        Uczen [] t = {u1,u2,u3,u4,u5};
        Uczniowie tuczniow = new Uczniowie(t);
        Uczniowie.wyswietl(t);
        Uczniowie.wyswietl(tuczniow.prymusy());
    }
}
