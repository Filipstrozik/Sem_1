import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner skan = new Scanner(System.in);
        System.out.println("Podaj liczbę X");
        double x = skan.nextDouble();
        double epsilon = 0.001;
        int n=100;
        int k=1;
        double temp=1;
        double sum =1;
        while(temp>epsilon){
            temp=temp*x/k;
            sum+=temp;
            k++;
        }
        System.out.println(sum);
    }
}