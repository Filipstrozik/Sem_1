package Figury;

import Interfejs.Pole_Kolo;
import Interfejs_ob.Obwod_Kolo;

public class Kolo extends Figura{
    double r;
    public Kolo(double r){
        super();
        this.r=r;
        pole=new Pole_Kolo();
        obwod= new Obwod_Kolo();
    }
    public double getR(){
        return r;
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