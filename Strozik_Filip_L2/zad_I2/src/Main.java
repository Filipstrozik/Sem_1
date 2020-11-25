import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner skan = new Scanner(System.in);
        int k=skan.nextInt();
        int sum = 0;
        while(k>0){
            sum+=k%10;
            k=k/10;
        }
        System.out.println(sum);
    }
}
