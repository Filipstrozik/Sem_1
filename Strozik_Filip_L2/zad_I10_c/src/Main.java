import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner skan = new Scanner(System.in);
        System.out.println("Podaj liczbę X");
        double x = skan.nextDouble();
        double epsilon = 0.01; //dokladnosc
        int k=1;
        int znak;
        double temp=1;
        double sum =1;
        double licznik=1;
        double mian=1;
        while(Math.abs(temp)>epsilon){
            licznik = licznik*x*x;
            mian = mian*(2*k)*(2*k-1);
            if(k%2!=0)
                znak=-1;
            else
                znak=1;
            temp=znak*licznik/mian;
            sum=sum+temp;
            System.out.println(temp+"   " +sum);
            k++;
        }
        System.out.println("Przyblizona wartosc funkcji dla wartosci x= "+x+" to "+sum);//co do wyniku to ta cała suma ciągu, zależnie od x wykracza poza wartosci cosinusa
    }
}