import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner skan = new Scanner(System.in);
        int k=skan.nextInt();
        int counter = 0;
        while(k>0){
            k=k/10;
            counter++;
        }
        System.out.println("Liczba naturalna K ma "+counter+" liczb znaczących.");
    }
}
