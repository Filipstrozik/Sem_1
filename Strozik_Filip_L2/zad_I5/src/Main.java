import java.util.Scanner;

public class Main {

    public static boolean czy_pierwsza(int k)
    {
        for(int i =2; i<k/2; i++)
        {
            if(k%i==0)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner skan = new Scanner(System.in);
        System.out.println("Podaj liczbę naturalną K.");
        int k=skan.nextInt();
        if(k<2)
        {
            System.out.println("K nie jest liczba pierwszą");
        }
        else if(czy_pierwsza(k))
        {
            System.out.println("K jest liczba pierwszą");
        }
        else
        {
            System.out.println("K nie jest liczba pierwszą");
        }
    }
}
