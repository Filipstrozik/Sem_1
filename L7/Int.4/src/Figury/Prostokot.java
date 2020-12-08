package Figury;

import Interfejs.Pole_prostokat;
import Interfejs_ob.Obwod_Prostokot;

public class Prostokot extends Figura{
    double a,b;
    public Prostokot(double bok1,double bok2){
        super();
        a=bok1;
        b=bok2;
        pole= new Pole_prostokat();
        obwod = new Obwod_Prostokot();
    }

    public double getA(){
        return a;
    }
    public double getB(){
        return b;
    }

    @Override
    public double oblicz_pole() {
        return pole.pole(this);
    }

    @Override
    public double oblicz_obwod() {
        return obwod.obwod(this);
    }
}
