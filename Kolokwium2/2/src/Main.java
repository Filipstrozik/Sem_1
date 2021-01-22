//Filip Strózik 260377
import java.io.*;
import java.util.Scanner;

class Zadanie {
    public void wykonaj(String nazwa){
        BufferedReader br =null;
        BufferedWriter bw = null;
        try{
            br = new BufferedReader(new FileReader(nazwa));
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku!");
        } catch (IOException e){
            System.out.println("I/O wyjątek");
        }
        try {
            bw = new BufferedWriter(new FileWriter("Studenci_wynik.txt"));
        } catch (IOException e) {
            System.out.println("I/O wyjątek");
        }
        try {
            String [] tokeny;
            double sum =0;
            String s = br.readLine();
            if(!s.equals("Lista studentow kierunku Informatyka")){
                System.out.println("to nie jest dobry plik!");
            }
            else {
                bw.write(s+"\n");
                s = br.readLine();
                s=s+"   Średnia ocena\n";
                bw.write(s);
                while ((s= br.readLine())!=null){
                    tokeny = s.split("\\s+");
                    sum = Double.parseDouble(tokeny[3])+Double.parseDouble(tokeny[4])+Double.parseDouble(tokeny[5]);
                    bw.write(s+"     "+sum/3.0+"\n");
                    sum=0;

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(br!=null){
                try {
                    br.close();
                }catch (IOException e){
                    System.out.println("problem przy zamykaniu strumienia");
                }
            }
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e){
                    System.out.println("problem przy zamykaniu strumienia");
                }
            }
        }
    }

}







public class Main {

    public static void main(String[] args) {
        Zadanie z =new Zadanie();
        Scanner sk = new Scanner(System.in);
        z.wykonaj(sk.next());
    }
}