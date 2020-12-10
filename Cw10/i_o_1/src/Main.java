import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	    Scanner sk =  new Scanner(System.in);
	    String nazwa_pliku = sk.nextLine();
	    String wyraz = sk.nextLine();
        int licznik=0;
	    String wiersz =null;
	    String [] tokeny;

        int lwierszy=0,lwyrazow=0,lznakowcz=0,liczbaznakow=0;

        BufferedReader  breader = null;
        try
        {
            breader = new BufferedReader(new FileReader(new File(nazwa_pliku)));
            while((wiersz= breader.readLine())!=null)
            {
                for(int i=0;i<wiersz.length();i++){
                    if(wiersz.charAt(i)==' ')
                    {
                        lznakowcz++;
                    }
                    liczbaznakow++;
                }
                tokeny = wiersz.split("[, ?.@!:();]");
                for(int i=0;i< tokeny.length;i++){
                    if(wyraz.equals(tokeny[i])){
                        licznik++;
                    }
                }
                lwyrazow = lwyrazow + tokeny.length;
                lwierszy++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            breader.close();
        }
        sk.close();
        System.out.println("Liczba wszystkich znakow: "+liczbaznakow);
        System.out.println("Liczba znakow czarnych: "+(liczbaznakow-lznakowcz));
        System.out.println("liczba wyrazow: "+lwyrazow);
        System.out.println("Liczba wierszy: "+lwierszy);
        System.out.println("Liczba wystąpien wyrazu "+wyraz+" = "+licznik);
    }
}
