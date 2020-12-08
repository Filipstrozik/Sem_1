package Figury;

import Interfejs.Pole;
import Interfejs_ob.Obwod;

public  abstract class Figura {
    protected Pole pole;
    protected Obwod obwod;
    abstract public double oblicz_pole();
    abstract public double oblicz_obwod();
}
