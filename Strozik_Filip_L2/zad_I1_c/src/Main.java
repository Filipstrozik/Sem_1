import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner skan = new Scanner(System.in);
        int n = skan.nextInt();
        double[] ciag = new double[n];
        for (int i=0;i<n;i++){
            ciag[i] = skan.nextDouble();
        }
        int counter =0;
        double sum = 0;
        for (int i=1; i<n; i++){
            if(ciag[i-1]>0)//liczba przed jest dodatnia
            {
                if(ciag[i]<=0)//aktualna liczba nie jest dodatnia,Uściślenie - "bezpośrednio" rozumiem,
                    // że w ciągu {2,3,-1,-2} nie bierzemy pod uwagę -2.
                {
                    //System.out.println(ciag[i]);
                    sum = sum + ciag[i];
                    counter++;
                }
            }
        }
        System.out.println("Srednia aryt. dodatnich wyrazów n-ciągu: " + sum/counter);
    }
}
