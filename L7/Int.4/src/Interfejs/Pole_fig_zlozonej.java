package Interfejs;

import Figury.Figura;
import Figury.FiguraZlozona;

public class Pole_fig_zlozonej implements Pole{
    @Override
    public double pole(Figura f) {
        FiguraZlozona figuraZlozona= (FiguraZlozona)f;
        double s=0.0;
        for(Figura fig:figuraZlozona.getFz())
        {
            s+=fig.oblicz_pole();
        }
        return s;
    }
}
