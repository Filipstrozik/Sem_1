import java.util.Scanner;
public class Main {

    public static long pot_rekuerncyjnie (int x, int K) //x=2 ,K=10 //x=2 K=5
    {
        if(K==0)
            return 1;
        else if(K%2!=0)//k nieparzyste
        {
            return x* pot_rekuerncyjnie(x,K-1);     //rekurencja// x=2 k=10 return 2^5 *2^5=32*32=1024      ^
        }                                              //       |     // x=2 K=5 return  2*2^4   = 2*16=32     |
        else//k parzyste  K=10                         //       |     // x=2 k=4 return 2^2 *2^2 = 4*4 =16     |
        {                                              //       |     // x=2 k=2 return 2*2^1    = 2*2 =4      |
            int temp = (int) pot_rekuerncyjnie(x,K/2);   //  V     // x=2 k=1 return 2*2^0    = 2*1 =2      | stos
            return temp*temp;
        }
    }

    public static void main(String[] args) {// potegowanie iteracyjne.
        Scanner skan = new Scanner(System.in);
        int pow=1;
        System.out.println("Podaj liczbę X");
        int X = skan.nextInt();
        System.out.println("Podaj liczbę K");
        int K = skan.nextInt();
        System.out.println("Potega liczby X do K = "+pot_rekuerncyjnie(X,K));
    }
}
