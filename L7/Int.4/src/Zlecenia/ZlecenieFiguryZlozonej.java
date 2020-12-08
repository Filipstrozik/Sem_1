package Zlecenia;

import Figury.Figura;
import Figury.FiguraZlozona;
import Koszt_Ciecia.Stawka1KosztuCiecia;
import Koszt_Materialu.Stawka1KosztuMaterialu;

public class ZlecenieFiguryZlozonej extends Zlecenie{
    FiguraZlozona f;
    public ZlecenieFiguryZlozonej(Figura[] t){
        f=new FiguraZlozona(t);
        koszt_ciecia = new Stawka1KosztuCiecia();
        koszt_materialu = new Stawka1KosztuMaterialu();
    }

    public void dopiszZlecenieFigury(Figura f){
        this.f.dopiszFigure(f);
    }

    public double kosztCiecia() {
        return koszt_ciecia.kosztCiecia(f.oblicz_obwod());

    }

    public double kosztMaterialu() {
        return koszt_materialu.koszt(f.oblicz_pole());
    }
}