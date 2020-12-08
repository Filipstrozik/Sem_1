package Figury;

import Interfejs.Pole_fig_zlozonej;
import Interfejs_ob.Obwod_fig_zlozonej;

public class FiguraZlozona extends Figura {
    Figura [] fz;
    public FiguraZlozona(Figura[] figz){
        fz=new Figura[figz.length];
        for(int i=0;i<fz.length;i++){
            fz[i]=figz[i];
        }
        pole= new Pole_fig_zlozonej();
        obwod = new Obwod_fig_zlozonej();
    }
    public void dopiszFigure(Figura f){
        Figura []temp = new Figura[fz.length+1];
        for(int i=0;i<fz.length;i++){
            temp[i]=fz[i];
        }
        temp[fz.length]=f;
        fz=temp;
    }

    public Figura [] getFz(){
        return fz;
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
