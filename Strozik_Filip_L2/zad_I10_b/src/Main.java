import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner skan = new Scanner(System.in);
        System.out.println("Podaj liczbę X");
        double x = skan.nextDouble();
        int k=1;
        int znak;
        double epsilon = 0.001;
        double temp=1;
        double sum =x;
        double licznik;
        double mian;
        while(Math.abs(temp)>epsilon){
            mian=1;
            licznik=x;
//            for(int i=2*k+1;i>0;i--) to nie jest sprytne podejscie
//            {
//                licznik=licznik*x;
//                mian=mian*i;
//            }
            licznik = licznik*x*x;
            mian = mian*(2*k)*(2*k+1);
            if(k%2!=0)
            {
                znak=-1;
            }
            else
            {
                znak=1;
            }
            temp=znak*licznik/mian;
            sum=sum+temp;
            System.out.println(temp+"   " +sum);// tu sprawdzałem przebieg można odkomentować i widzieć każdy element sumy.
            k++;
        }
        System.out.println("Przyblizona wartosc funkcji dla wartosci x= "+x+" to "+sum);//co do wyniku to ta cała suma ciągu, zależnie od x wykracza poza wartosci sinusa
    }
}