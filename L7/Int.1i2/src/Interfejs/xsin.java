package Interfejs;

public class xsin implements Funkcja {
    @Override
    public double f(double x) {
        return x*Math.sin(x);
    }

    @Override
    public String wzor() {
        return "f(x) = xsinx";
    }
}