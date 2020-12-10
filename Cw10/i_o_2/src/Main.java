import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
class Tablica{
    private int w;
    private int k;
    private int [][] t;

    public Tablica(){
        Scanner sk = new Scanner(System.in);
        w = sk.nextInt();
        k = sk.nextInt();
        t = new int[w][k];
        for(int i=0;i<t.length;i++){
            for(int j=0;j<t[i].length;j++){
                t[i][j]= sk.nextInt();
            }
        }
    }

    public double srednia(){
        int suma = 0;
        for(int i=0;i<t.length;i++){
            for(int j=0;j<t[i].length;j++){
                suma = suma+t[i][j];
            }
        }
        return (double) suma/(w*k);
    }

    public String toString(){
        String s= "\n";
        for(int i=0;i<t.length;i++){
            for(int j=0;j<t[i].length;j++){
                s=s+String.format("%5d"  ,t[i][j]);
            }
            s=s+"\n";
        }
        return s;
    }

    public String wyswietlTransponowana(){
        String s= "\n";
        for(int i=0;i<t.length;i++){
            for(int j=0;j<t[i].length;j++){
                s=s+String.format("%5d"  ,t[j][i]);
            }
            s=s+"\n";
        }
        return s;
    }
}

class Tablica2{
    private int w;
    private int k;
    private int [][] t;

    public Tablica2() throws IOException {
        BufferedReader breader = null;
        try {
            breader = new BufferedReader(new InputStreamReader(System.in));
            w = Integer.parseInt(breader.readLine());
            k = Integer.parseInt(breader.readLine());
            t = new int[w][k];
            for (int i = 0; i < t.length; i++) {
                String wiersz = breader.readLine();
                String [] tokeny = wiersz.split(" ");
                for(int j=0;j<t[i].length;j++){
                    t[i][j] = Integer.parseInt(tokeny[j]);
                }

            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally
        {
            breader.close();
        }
    }

    public double srednia(){
        int suma = 0;
        for(int i=0;i<t.length;i++){
            for(int j=0;j<t[i].length;j++){
                suma = suma+t[i][j];
            }
        }
        return (double) suma/(w*k);
    }

    public String toString(){
        String s= "\n";
        for(int i=0;i<t.length;i++){
            for(int j=0;j<t[i].length;j++){
                s=s+String.format("%5d"  ,t[i][j]);
            }
            s=s+"\n";
        }
        return s;
    }

    public String wyswietlTransponowana(){
        String s= "\n";
        for(int i=0;i<t.length;i++){
            for(int j=0;j<t[i].length;j++){
                s=s+String.format("%5d"  ,t[j][i]);
            }
            s=s+"\n";
        }
        return s;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
//        Tablica t1 = new Tablica();
//        System.out.println("srednia : "+t1.srednia());
//        System.out.println(t1);
//        System.out.println(t1.wyswietlTransponowana());

        Tablica2 t2 = new Tablica2();
        System.out.println("srednia : "+t2.srednia());
        System.out.println(t2);
        System.out.println(t2.wyswietlTransponowana());
    }
}
