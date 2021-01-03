import java.io.*;
import java.util.Scanner;

class Macierz {
    private int w;
    private int k;
    double [][] dane;

    public void generuj(int wiersz, int kolumna) {
        w = wiersz;
        k = kolumna;
        double[][] temp = new double[w][k];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < k; j++) {

                temp[i][j] = Math.round((Math.random() * 10)*100.0)/100.0;
            }
        }
        dane = temp;
    }

    public void zapisz(String nazwa) throws IOException {
        File plik = new File(nazwa);
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(plik));
        dos.writeInt(w);
        dos.writeInt(k);
        for (int i = 0; i < w; i++) {
            for (int j=0;j < k;j++){
                dos.writeDouble(dane[i][j]);
            }
        }
        dos.close();
    }

    public void odczytaj(String nazwa) throws IOException {
        File odczyt = new File(nazwa);
        DataInputStream dis = new DataInputStream(new FileInputStream(odczyt));
        w = dis.readInt();
        System.out.println(w);
        k = dis.readInt();
        System.out.println(k);
        for(int i=0;i<w;i++){
            for(int j=0;j<k;j++){
                double d = dis.readDouble();
                System.out.printf(" %5.2f ", d);
            }
            System.out.println();
        }
    }

}


public class Main {
    public static void main(String[] args) throws IOException {
        Macierz m = new Macierz();
        m.generuj(5,6);
        m.zapisz("macierz.txt");
        m.odczytaj("macierz.txt");
    }

}
