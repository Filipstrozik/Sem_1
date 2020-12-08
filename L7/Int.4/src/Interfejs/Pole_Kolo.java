package Interfejs;

import Figury.Figura;
import Figury.Kolo;

public class Pole_Kolo implements Pole{

    @Override
    public double pole(Figura f) {
        Kolo k = (Kolo)f;
        k.getR();
        return k.getR()*k.getR()*3.14;
    }
}
