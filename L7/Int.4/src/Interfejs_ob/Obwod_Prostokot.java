package Interfejs_ob;

import Figury.Figura;
import Figury.Prostokot;

public class Obwod_Prostokot implements Obwod {
    @Override
    public double obwod(Figura f) {
        Prostokot p = (Prostokot)f;
        return 2*(p.getA()+p.getB());
    }
}
