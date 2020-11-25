import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner skan = new Scanner(System.in);
        int n = skan.nextInt();
        int counter =0;
        double sum = 0;
        for (int i=0;i<n;i++){
            double k = skan.nextDouble();
            if(k>0) {
                sum = sum + k;
                counter++;
            }
        }
        System.out.println("Srednia aryt. dodatnich wyrazów n-ciągu: "+sum/counter);
    }
}
