public class Main {

    public static double f(double x){
        double sum=0;
        double temp=1;
        int mian=1;
        while(temp>0.0001)
        {
            temp= temp*(x-1)/(x*mian);
            mian++;
            sum=sum+temp;
        }
        return sum;
    }

    public static void fun2(double [] t){
        System.out.println("Tabela wyników:");
        for(double x: t){
            System.out.printf("\t %3.2f %2.3f %n",x,f(x));
        }
    }

    public static void main(String[] args) {
        double x = 3.14566;
        System.out.printf("\t %3.2f %3.3f %n",x,f(x));
        double [] tabela_argumentow = {2.144,3.123,4.123,5.123,6.123};
        fun2(tabela_argumentow);
    }
}
