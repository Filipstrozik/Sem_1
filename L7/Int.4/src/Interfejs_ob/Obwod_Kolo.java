package Interfejs_ob;

import Figury.Figura;
import Figury.Kolo;

public class Obwod_Kolo implements Obwod {
    @Override
    public double obwod(Figura f) {
        Kolo k = (Kolo)f;
        return 3.13*2.0*k.getR();
    }
}
