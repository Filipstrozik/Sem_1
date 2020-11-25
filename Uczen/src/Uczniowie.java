public class Uczniowie {
    Uczen [] tablica_u;
    public Uczniowie(Uczen [] t){
        tablica_u = new Uczen[t.length];
        for(int i=0;i<t.length;i++){
            tablica_u[i]=t[i];
        }
    }
    public Uczen [] prymusy(){
        int c=0;
        for(int i=0;i<tablica_u.length;i++){
            if(tablica_u[i].ocena==6.0){
                c++;
            }
        }
        Uczen [] temp= new Uczen[c];
        c=0;
        {
            for(int i=0;i<tablica_u.length;i++){
                if(tablica_u[i].ocena==6.0){
                    temp[c++]=tablica_u[i];
                }
            }
        }
        return temp;

    }

    public static void wyswietl(Uczen [] t){
        for(int i=0;i<t.length;i++){
            System.out.println(t[i]);
        }
    }
}
