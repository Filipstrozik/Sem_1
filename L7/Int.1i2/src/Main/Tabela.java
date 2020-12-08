package Main;

import Interfejs.Funkcja;

public class Tabela {
    protected Funkcja funkcja;
    private double xp, xk, dx;

    public Tabela(Funkcja f, double xp, double xk, int n) {
        funkcja = f;
        this.xp = xp;
        this.xk = xk;
        dx = (xk - xp) / n;
    }

    public String toString() {
        String s = funkcja.wzor() + "\n";
        s = s + String.format("%10s %10s \n", "x", "f(x)");
        double x = xp;
        String temp;
        do {
            double fx = funkcja.f(x);
            temp = String.format("%10.2f %10.3f", x, fx);
            s = s + temp + "\n";
            x += dx;
        } while (x <= xk);
        return s;
    }
}
