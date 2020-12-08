package Zlecenia;

import Koszt_Ciecia.*;
import Koszt_Materialu.*;

public abstract class Zlecenie{
    protected Koszt_Ciecia koszt_ciecia;
    protected Koszt_Materialu koszt_materialu;
    public abstract double kosztCiecia();
    public abstract double kosztMaterialu();
}