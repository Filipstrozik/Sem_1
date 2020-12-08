package Interfejs_ob;

import Figury.Figura;
import Figury.FiguraZlozona;

public class Obwod_fig_zlozonej implements Obwod{
    @Override
    public double obwod(Figura f) {
        FiguraZlozona figuraZlozona = (FiguraZlozona)f;
        double s=0.0;
        for(Figura fig:figuraZlozona.getFz())
        {
            s+=fig.oblicz_obwod();
        }
        return s;
    }
}
