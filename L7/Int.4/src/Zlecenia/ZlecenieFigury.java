package Zlecenia;

import Figury.Figura;
import Koszt_Ciecia.Stawka1KosztuCiecia;
import Koszt_Materialu.Stawka1KosztuMaterialu;

public class ZlecenieFigury extends Zlecenie{
    Figura f;

    public ZlecenieFigury(Figura fig) {
        f = fig;
        koszt_ciecia = new Stawka1KosztuCiecia();
        koszt_materialu = new Stawka1KosztuMaterialu();
    }


    @Override
    public double kosztCiecia() {
        return koszt_ciecia.kosztCiecia(f.oblicz_obwod());
    }

    @Override
    public double kosztMaterialu() {
        return koszt_materialu.koszt(f.oblicz_pole());
    }
}