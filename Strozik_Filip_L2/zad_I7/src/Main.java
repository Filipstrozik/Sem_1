import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner skan = new Scanner(System.in);
        int M = skan.nextInt();
        int N = skan.nextInt();
        while(N!=0){
            int dzielnik = M%N;
            //System.out.println(M + " " + N+" "+dzielnik );
            M=N;
            N=dzielnik;

        }
        System.out.println("dzielnik: "+M);
    }
}
