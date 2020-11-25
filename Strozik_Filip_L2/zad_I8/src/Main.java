import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner skan = new Scanner(System.in);
        int M = skan.nextInt();
        int N = skan.nextInt();
        int temp;
        while(M!=N){
            if(M>N)
            {
                temp = M-N;
                //System.out.println(M + " " + N+" "+dzielnik );
                M=N;
                N=temp;
            }
            else
            {
                temp = N-M;
                //System.out.println(M + " " + N+" "+dzielnik );
                N=M;
                M=temp;
            }
        }
        System.out.println("dzielnik= "+M);
    }
}
