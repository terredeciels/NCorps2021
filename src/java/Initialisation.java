package java;

import java.math.BigDecimal;

public class Initialisation {

    private final BigDecimal Gm; // < 0
    private final Corps[] NCorpsT0;
    private final int nbDeCorps;

    public Initialisation(BigDecimal gm, int nbDeCorps) {
        this.nbDeCorps = nbDeCorps;
        NCorpsT0 = new Corps[nbDeCorps];
        Gm = gm;
        for (int n = 0; n < nbDeCorps; n++) {
            BigDecimal[] param = new BigDecimal[6];
            for (int c = 0; c < 6; c++) {
                param[c] = BigDecimal.valueOf(Math.random());// 0 a 1 ?
                //preciser les domaines
            }
            Corps corps = new Corps(param);
            NCorpsT0[n] = corps;
        }

    }

    public Corps[] getNCorpsT0() {
        return NCorpsT0;
    }

    public BigDecimal getGm() {
        return Gm;
    }

    public int getNbDeCorps() {
        return nbDeCorps;
    }

    public void calculate(BigDecimal pas) {
        new Calcul(this,pas);
    }
}
