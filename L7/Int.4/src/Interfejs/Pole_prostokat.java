package Interfejs;

import Figury.Figura;
import Figury.Prostokot;

public class Pole_prostokat implements Pole {
    @Override
    public double pole(Figura f) {
        Prostokot p = (Prostokot)f;
        return p.getA()*p.getB();
    }
}
