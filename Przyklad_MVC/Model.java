//package mvc.model;

import java.math.BigInteger;

public class Model {

    private static final String WartoscPoczatkowa = "1";

    private BigInteger Suma;

    public Model() {
        kasuj();
    }

    public void kasuj() {
        Suma = new BigInteger(WartoscPoczatkowa);
    }

    public void multiplyBy(String input) {
        Suma = Suma.multiply(new BigInteger(input));
    }

    public void setValue(String value) {
        Suma = new BigInteger(value);
    }

    public String getValue() {
        return Suma.toString();
    }

}
