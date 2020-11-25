import java.util.Scanner;
public class Main {

    public static void main(String[] args) {// potegowanie iteracyjne.
        Scanner skan = new Scanner(System.in);
        int pow=1;
        System.out.println("Podaj liczbę X");
        int X = skan.nextInt();
        System.out.println("Podaj liczbę K");
        int K = skan.nextInt();
        while(K>0){//dla k=0 potega jest równa 1.
            pow = pow*X;
            K--;
        }
        System.out.println("Potega liczby X do K = "+pow);
    }
}
