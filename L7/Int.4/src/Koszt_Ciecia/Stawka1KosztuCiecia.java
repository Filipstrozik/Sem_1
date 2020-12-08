package Koszt_Ciecia;

public class Stawka1KosztuCiecia implements Koszt_Ciecia{

    double stawka1=7.99;

    @Override
    public double kosztCiecia(double x) {
        return stawka1*x;
    }
}
