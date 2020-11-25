import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner skan = new Scanner(System.in);
        int n = skan.nextInt();
        double sum = skan.nextDouble();
        for (int i=1;i<n;i++){
            double k = skan.nextDouble();
            sum = sum+k;
        }
        System.out.println("Suma wszystkich wyrazów n-ciągu: "+sum);
    }
}
