//Strózik Filip
//260377

public class Main {

    public static double f(double x){
        double sum=1;
        int temp=2;
        long mian=2;
        double licznik=1;
        while(Math.abs(licznik/mian)>0.001)
        {
            licznik = licznik*x*x*(-1);
            sum=sum+(licznik/mian);
            mian = mian*(temp+1)*(temp+2);
            temp+=2;
//            System.out.println(mian+" "+licznik+" "+ mian+" "+sum);

        }
        return sum;
    }

    public static void fun2(double [] t){
        System.out.println("Tabela wyników:\n X: \t f(x)");
        for(double x: t){
            System.out.printf("%4.2f",x);
            System.out.print("    ");
            System.out.printf("%2.3f %n",f(x));
        }
    }

    public static void main(String[] args) {
        double x = 1.00;
        System.out.printf("\t %3.2f %3.3f %n",x,f(x));
        double [] tabela_argumentow = {1.21,6.10,4.123,5.123,6.123};
        fun2(tabela_argumentow);
    }
}