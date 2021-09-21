package jvm.BigDec;

import java.math.BigDecimal;

public class Launch {
    public static void main(String[] argv) {
        BigDecimal gm = BigDecimal.valueOf(1);
        BigDecimal pas = BigDecimal.valueOf(1);
        int Tmax = 50;
        new Initialisation(gm, 10, Tmax).calculate(pas);
    }
}
