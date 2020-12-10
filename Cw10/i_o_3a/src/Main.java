import java.io.*;
import java.util.Scanner;

public class Main {

    public static double[][] Tablica(){
        int w = 4;
        int k = 6;
        double [][] temp =  new double[w][k];
        for(int i=0;i< temp.length;i++)
        {
            for(int j=0;j< temp[i].length;j++){
                temp[i][j]= (Math.random()*20)-10;
            }
        }
        return temp;
    }

    public static void wyswietlNaEkran(double [][] t) throws IOException {
        BufferedWriter bwr = new BufferedWriter(new PrintWriter(System.out));
        String s = "";
        for(double [] wiersz: t)
        {
            for(double komorka: wiersz){
                s=s+String.format(" %5.2f "  ,komorka);
            }
            bwr.write(s);
            s="\n";
        }
        bwr.newLine();
        bwr.flush();
    }

    public static void zapiszDoPliku(double [][] t) throws IOException {
        BufferedWriter bwr = new BufferedWriter(new FileWriter(new File("Macierz.txt")));
        String s = "Macierz\n"+t.length+" "+t[0].length+"\n";
        bwr.write(s);
        s="";
        for(double [] wiersz: t)
        {
            for(double komorka: wiersz){
                s=s+String.format(" %5.2f "  ,komorka);
            }
            bwr.write(s);
            s="\n";
        }
        bwr.close();
    }
    public static void czytaj() throws FileNotFoundException, InterruptedException {
        Scanner sc = new Scanner(new FileReader(new File("Macierz.txt")));

        System.out.println(sc.nextLine());
        int w = sc.nextInt();
        int k = sc.nextInt();
        for(int i=0;i<w;i++){
            for(int j=0;j<k;j++){
                System.out.printf(" %5.2f "  ,sc.nextDouble());
            }
            
            System.out.println();
        }
        sc.close();
    }



    public static void main(String[] args) throws IOException, InterruptedException {
        double [][] t = Tablica();
	    wyswietlNaEkran(t);
	    zapiszDoPliku(t);
	    czytaj();
    }
}
