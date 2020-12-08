package Koszt_Materialu;

public class Stawka1KosztuMaterialu implements Koszt_Materialu{
    double stawka1 = 5.99;

    @Override
    public double koszt(double x) {

        return stawka1*x;
    }
}
