package java;

import java.math.BigDecimal;

public class Launch {
    public static void main(String[] argv) {
        BigDecimal gm = BigDecimal.valueOf(1);
        BigDecimal pas = BigDecimal.valueOf(1);
        new Initialisation(gm,10).calculate(pas);
    }
}
