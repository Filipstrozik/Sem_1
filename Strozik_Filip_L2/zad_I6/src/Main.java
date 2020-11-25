import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	    Scanner skan = new Scanner(System.in);
	    int M = skan.nextInt();
	    int N = skan.nextInt();
	    int dzielnik;
	    if(M>N) // M<=N pomaga, lecz wystarczy tylko zamienić ze sobą M i N.
            dzielnik = N;
	    else
            dzielnik = M;
	    while(dzielnik>0){
	        if(N%dzielnik==0 && M%dzielnik==0)
            {
                System.out.println("NWD liczb M i N = "+dzielnik);
                break;
            }
	        else
            {
                dzielnik--;
            }
        }
    }
}
