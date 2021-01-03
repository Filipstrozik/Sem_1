import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Rekordy {
    ArrayList<Pomiar> lista = new ArrayList<>();

    public void dodaj(Pomiar p){
        lista.add(p);
    }

    public void zapisz() throws IOException {
        ObjectOutputStream obos = new ObjectOutputStream(new FileOutputStream("rekordy.dat"));
        for(Pomiar pomiar :lista){
            obos.writeObject(pomiar);
        }
        obos.close();

    }

    public void dopiszPomiar(Pomiar p) throws IOException{ //Dodatkowo
        ObjectInputStream obs = new ObjectInputStream(new FileInputStream("rekordy.dat"));
        lista.clear();
        while(true){
            try{
                lista.add((Pomiar) obs.readObject());
            }
            catch (EOFException | ClassNotFoundException e){
                break;
            }
        }
        obs.close();
        lista.add(p);
        ObjectOutputStream obos = new ObjectOutputStream(new FileOutputStream("rekordy.dat"));
        for(Pomiar pomiar :lista){
            obos.writeObject(pomiar);
        }
        obos.close();
    }


    public void dopiszPomiarChronologicznie(Pomiar p) throws IOException{ //dodatkowo
        ObjectInputStream obs = new ObjectInputStream(new FileInputStream("rekordy.dat"));
        lista.clear();
        while(true){
            try{
                lista.add((Pomiar) obs.readObject());
            }
            catch (EOFException | ClassNotFoundException e){
                break;
            }
        }
        obs.close();
        lista.add(p);
        Collections.sort(lista);
        ObjectOutputStream obos = new ObjectOutputStream(new FileOutputStream("rekordy.dat"));
        for(Pomiar pomiar :lista){
            obos.writeObject(pomiar);
        }
        obos.close();
    }

    public void odczytaj(String nazwa) throws IOException {
        ObjectInputStream obs = new ObjectInputStream(new FileInputStream(nazwa));
        lista.clear();
        while(true){
            try{
                lista.add((Pomiar) obs.readObject());
            }
            catch (EOFException | ClassNotFoundException e){
                break;
            }
        }
        obs.close();
        for(Pomiar pomiar :lista)
        {
            System.out.println(pomiar);
        }
    }

    public void wypiszPomiaryWMiesiacuWRoku(int mies,int rok){ //dodatkowo
        for(Pomiar pomiar :lista)
        {
            if(pomiar.czas.miesiac==mies && pomiar.czas.rok==rok)
            {
                System.out.println(pomiar);
            }
        }
    }
}



class Pomiar implements Serializable, Comparable<Pomiar>{
    Czas czas;
    double temperatura;
    public Pomiar (Czas c , double t){
        czas = c;
        temperatura =t;
    }

    @Override
    public String toString() {
        return "Pomiar{" +
                "czas=" + czas +
                ", temperatura=" + temperatura +
                '}';
    }

    @Override
    public int compareTo(Pomiar p) {
        if(czas.rok > p.czas.rok) return 1;
        if(czas.rok < p.czas.rok) return -1;
        if(czas.miesiac > p.czas.miesiac) return 1;
        if(czas.miesiac < p.czas.miesiac) return -1;
        if(czas.dzien > p.czas.dzien) return 1;
        if(czas.dzien < p.czas.dzien) return -1;
        if(czas.godzina > p.czas.godzina) return 1;
        if(czas.godzina < p.czas.godzina) return -1;
        if(czas.minuta > p.czas.minuta) return 1;
        if(czas.minuta < p.czas.minuta) return -1;
        return 0;
    }
}

class Czas implements Serializable{
    int rok, miesiac, dzien, godzina, minuta;
    public Czas(int r, int m, int dz, int g,int mi)
    {
        rok = r;
        miesiac = m;
        dzien = dz;
        godzina = g;
        minuta = mi;
    }

    @Override
    public String toString() {
        return "Czas{" +
                "rok=" + rok +
                ", miesiac=" + miesiac +
                ", dzien=" + dzien +
                ", godzina=" + godzina +
                ", minuta=" + minuta +
                '}';
    }
}


public class Main {
    public static void dopiszNaKoniec(Pomiar p) throws IOException {
        File plik1 = new File("temp.dat");
        File plik2 =  new File("rekordy.dat");
        ObjectInputStream obs = new ObjectInputStream(new FileInputStream(plik2));
        ObjectOutputStream obos = new ObjectOutputStream(new FileOutputStream(plik1));
        while(true){
            try{
                obos.writeObject(obs.readObject());
            }
            catch (EOFException | ClassNotFoundException e){
                break;
            }
        }
        obos.writeObject(p);
        obs.close();
        obos.close();
        plik2.delete();
        plik1.renameTo(new File("rekordy.dat"));

    }


    public static void dopiszChrono(Pomiar p) throws IOException {
        File plik1 = new File("temp.dat");
        File plik2 =  new File("rekordy.dat");
        ObjectInputStream obs = new ObjectInputStream(new FileInputStream(plik2));
        ObjectOutputStream obos = new ObjectOutputStream(new FileOutputStream(plik1));
        boolean flag = false;
        while(true){
            try{
                Pomiar t_p = (Pomiar) obs.readObject();
                if(p.compareTo(t_p)==-1){
                    obos.writeObject(p);
                    obos.writeObject(t_p);
                    flag = true;
                }
                else{
                    obos.writeObject(t_p);
                    flag = false;
                }
            }
            catch (EOFException | ClassNotFoundException e){
                if(!flag){
                    obos.writeObject(p);
                }
                break;
            }
        }
        obs.close();
        obos.close();
        plik2.delete();
        plik1.renameTo(new File("rekordy.dat"));

    }

    public static void pomiaryWeWskazanymMiesiacuWRoku(int mies,int rok) throws IOException {
        File plik2 =  new File("rekordy.dat");
        ObjectInputStream obs = new ObjectInputStream(new FileInputStream(plik2));
        while(true){
            try{
                Pomiar t_p = (Pomiar) obs.readObject();
                if(t_p.czas.rok==rok && t_p.czas.miesiac==mies)
                {
                    System.out.println(t_p);
                }
            }
            catch (EOFException | ClassNotFoundException e){
                break;
            }
        }
        obs.close();
    }

    public static void Ocieplenie(int mies, int rok) throws IOException {
        File plik2 =  new File("rekordy.dat");
        ObjectInputStream obs = new ObjectInputStream(new FileInputStream(plik2));
        Pomiar t_p1 = null;
        try{
            t_p1 = (Pomiar) obs.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                Pomiar t_p2 = (Pomiar) obs.readObject();
                if (t_p1.temperatura < t_p2.temperatura ){
                    System.out.println(t_p2.czas.dzien);
                }
                t_p1 = t_p2;
            }
            catch (EOFException | ClassNotFoundException e){
                    break;
                }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Czas c1 = new Czas(2020,1,1,1,1);
        Czas c2 = new Czas(2020,1,2,1,1);
        Czas c3 = new Czas(2020,1,3,1,1);
        Pomiar p1 = new Pomiar( c1, 11.45);
        Pomiar p2 = new Pomiar( c2, 16.45);
        Pomiar p3 = new Pomiar(c3,40.23);
        Rekordy r = new Rekordy();
        r.dodaj(p1); // plik nie może być pusty
        r.zapisz();

        dopiszChrono(p3);
        dopiszChrono(p2);

        System.out.println("__rekordy wszystkie_________");

        r.odczytaj("rekordy.dat");
        System.out.println("_Pomiary we wskazanym miesiacu okreslonego roku__________");
        pomiaryWeWskazanymMiesiacuWRoku(1,2020);
        Ocieplenie(1,2020);

    }
}
