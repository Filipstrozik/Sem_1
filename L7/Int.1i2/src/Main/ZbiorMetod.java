package Main;

import Interfejs.Funkcja;

public class ZbiorMetod {
    private Funkcja funkcja;

    ZbiorMetod(Funkcja f){
        funkcja=f;
    }

    public void setFunkcja(Funkcja f){
        funkcja=f;
    }

    public double pochodna (double x, double h){
        return ((funkcja.f(x+h)- funkcja.f(x))/h);
    }

    public double druga_pochodna(double x0,double h)
    {
        double pom1 = pochodna(x0+h,h);//pom1 i pom 2 by pomoc sobie do wzoru to wsadzic
        //System.out.println(pom1);
        double pom2 = pochodna(x0,h);
        //System.out.println(pom2);
        double wynik =(pom1 -pom2)/h;
        //System.out.println(pom1-pom2);
        return wynik;
    }

    public double miejsceZerowewPrzedziale(double xp, double xk){
        double midx=((xk-xp)/2.0)+xp;
        double flewy = funkcja.f(xp);
        double fmid = funkcja.f(midx);
        //System.out.println(lewy+"  "+ midx+"  "+prawy+"   "+ fmid);
        if(Math.abs(fmid)<=0.001) {
            return Math.round((((xk-xp)/2.0)+xp)*100.0)/100.0;
        }
        else {
            if(flewy*fmid<0.0)
            {
                return miejsceZerowewPrzedziale(xp,midx);
            }
            else {
                return miejsceZerowewPrzedziale(midx,xk);
            }
        }
    }

    public double ekstremum(double lewy,double prawy)
    {
        if(lewy==prawy)
        {
            System.out.println("nie ma ekstremum");
            return 0;
        }
        else{
            double midx=((prawy-lewy)/2.0)+lewy;
            double flewy = pochodna(lewy,0.01);
            double fmid = pochodna(midx,0.01);
            //System.out.println(lewy+"  "+ midx+"  "+prawy+"   "+ fmid);
            if(Math.abs(fmid)<=0.001)
            {
                return Math.round(midx*100.0)/100.0;
            }
            else
            {
                if(flewy*fmid<0.0)
                {
                    return ekstremum(lewy,midx);
                }
                else
                {
                    return ekstremum(midx,prawy);
                }
            }
        }
    }

    public double przegiecie(double lewy,double prawy)
    {
        double midx=((prawy-lewy)/2.0)+lewy;
        double flewy = druga_pochodna(lewy,0.01);
        double fmid = druga_pochodna(midx,0.01);
        //System.out.println(lewy+"  "+ midx+"  "+prawy+"   "+ fmid);
        if(Math.abs(fmid)<=0.0001)
        {
            //System.out.println(midx);
            return Math.round(midx*100.0)/100.0;
        }
        else
        {
            if(flewy*fmid<0.0)
            {
                return przegiecie(lewy,midx);
            }
            else
            {
                return przegiecie(midx,prawy);
            }
        }

    }

    public double calka(double n, double xp, double xk){
        double suma =0;
        double dx = (xk - xp) / n;
        for(int i=0;i<n;i++){
            suma=suma+ funkcja.f(xp+i*dx);
        }
        suma = (suma +(funkcja.f(xp)+ funkcja.f(xk))/2)*dx;
        return Math.round(suma*100.0)/100.0;
    }
}
