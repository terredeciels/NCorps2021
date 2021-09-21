package jvm.BigDec;

import java.math.BigDecimal;
import java.math.MathContext;

public class Calcul {

    int precision = 10;
    MathContext mc = new MathContext(precision);
    private Corps[] ncorps;
    private BigDecimal pas;
    private int nbcorps;

    public Calcul(Initialisation init, BigDecimal p) {
        init.getNCorpsT0();
        nbcorps = init.getNbDeCorps();
        pas = p;
        for (int k = 0; k < init.getTmax(); k++) {


            for (int n = 0; n < nbcorps; n++) { //corps n
                BigDecimal fx = BigDecimal.valueOf(0);
                BigDecimal fy = BigDecimal.valueOf(0);
                BigDecimal fz = BigDecimal.valueOf(0);
                for (int m = 0; m < nbcorps; m++) {
                    if (n != m) {
                        BigDecimal dx = ncorps[n].getParam()[0].subtract(ncorps[n].getParam()[0]);
                        BigDecimal dy = ncorps[n].getParam()[1].subtract(ncorps[n].getParam()[1]);
                        BigDecimal dz = ncorps[n].getParam()[2].subtract(ncorps[n].getParam()[2]);

                        BigDecimal Denom = ((dx.pow(2).add(dy.pow(2)).add(dz.pow(2))).sqrt(mc)).pow(3);
                        fx = fx.add(dx.divide(Denom));
                        fy = fy.add(dx.divide(Denom));
                        fz = fz.add(dx.divide(Denom));
                    }
                }
            }


        }
    }
}

