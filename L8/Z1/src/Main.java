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
        BufferedWriter bwr =  new BufferedWriter(new FileWriter(plik));
        String s = "Macierz\n"+w+"\n"+k+"\n";
        bwr.write(s);
        s="";
        for (int i = 0; i < w; i++) {
            for (int j=0;j < k;j++){
                s=s+String.format(" %5.2f ",dane[i][j]);
            }
            bwr.write(s);
            s="\n";
        }
        bwr.close();
    }

    public void odczytaj(String nazwa) throws IOException {
        File odczyt = new File(nazwa);
        Scanner br = new Scanner(odczyt);
        if(br.next().equals("Macierz")){
            System.out.println("Macierz");
            w = br.nextInt();
            System.out.println(w);
            k = br.nextInt();
            System.out.println(k);
            for(int i=0;i<w;i++){
                for(int j=0;j<k;j++){
                    System.out.printf(" %5.2f ", br.nextDouble());
                }
                System.out.println();
            }
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
