import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner skan = new Scanner(System.in);
        System.out.println("Podaj liczbę naturalną K.");
        int k=skan.nextInt();
        int max = 0;
        int temp;
        while(k>0){
            temp = k%10;
            if(max<temp) //0<1  , 1<2
            {
                max=temp;
            }
            else
            {

            }
            k=k/10;
        }
        System.out.println("Cyfra "+max+" jest największą cyfrą w Liczbie K.");
    }
}
