package jvm.dble;

public class Initialisation {

    private final double Gm; // < 0
    private final Corps[][] NCorpsT0;
    private final int nbDeCorps;
    private final int Tmax;
    private final double pas;
    private final int DimXYZ;

    public Initialisation(double gm, int nbdecorps, int tmax, double p, int dimXYZ) {
        DimXYZ=dimXYZ;
        Gm = gm;
        pas = p;
        Tmax = tmax;
        nbDeCorps = nbdecorps;
        NCorpsT0 = new Corps[nbDeCorps][Tmax];

        for (int n = 0; n < nbDeCorps; n++) {
            Corps corps = new Corps();
            double[] param = new double[6];
            for (int c = 0; c < 6; c++) {
                param[c] = Math.random()*DimXYZ;// 0 a 1 ?
                //System.out.print(param[c]);
                //preciser les domaines
            }
            corps.setParam(param);
            NCorpsT0[n][0] = corps;
        }

    }

    public double getPas() {
        return pas;
    }

    public int getTmax() {
        return Tmax;
    }

    public Corps[][] getNCorpsT0() {
        return NCorpsT0;
    }

    public double getGm() {
        return Gm;
    }

    public int getNbDeCorps() {
        return nbDeCorps;
    }

    public void calculate() {
        new Calcul(this);
    }


}
