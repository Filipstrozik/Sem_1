public class Zakup implements ListaDanych{
    String info;
    Towar [] t_towarow;
    public Zakup(String i,Towar [] t){
        info = i;
        t_towarow = t;
    }

    public void DodajTowar(Towar t){
        Towar [] temp = new Towar[t_towarow.length+1];
        for(int i=0;i<t_towarow.length;i++){
            temp[i]=t_towarow[i];
        }
        temp[t_towarow.length]=t;
        t_towarow=temp;
    }

    public double lacznaWartosc(){
        double temp=0.0;
        for(int i=0;i< t_towarow.length;i++){
            temp = temp+ t_towarow[i].wartosc;
        }
        return temp;
    }


    @Override
    public String [] lista() {
        String [] s = new String[t_towarow.length];
        for(int i=0;i< t_towarow.length;i++){
            s[i] = String.format("%10s  %10d  %10.2f %10.2f \n",t_towarow[i].nazwa,t_towarow[i].ilosc,t_towarow[i].cena
            ,t_towarow[i].wartosc);
        }
        return s;
    }

    @Override
    public String naglowek_listy() {
        return String.format("%2s %10s  %10s  %10s %10s \n","L.p" ,"nazwa", "ilosc",
                "cena", "wartosc");
    }

    @Override
    public String infozestawienia() {
        return info+"\n";
    }

    @Override
    public String dodatkowe_info() {
        return String.format("Laczna wartosc towarow : %7.2f", lacznaWartosc());
    }
}
