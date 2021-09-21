package jvm.dble;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Calcul {


    public Calcul(Initialisation init) {
        double Gm = init.getGm();
        Corps[][] ncorps = init.getNCorpsT0();
        int nbcorps = init.getNbDeCorps();
        double pas = init.getPas();

        for (int k = 0; k < init.getTmax() - 1; k++) {
            for (int n = 0; n < nbcorps; n++) { //corps n
                double fx = 0.0;
                double fy = 0.0;
                double fz = 0.0;
                for (int m = 0; m < nbcorps; m++) {
                    if (n != m) {
                        double dx = ncorps[n][k].getParam()[0] - ncorps[n][k].getParam()[0];
                        double dy = ncorps[n][k].getParam()[1] - ncorps[n][k].getParam()[1];
                        double dz = ncorps[n][k].getParam()[2] - ncorps[n][k].getParam()[2];

                        double Denom = pow(sqrt(pow(dx, 2) + pow(dy, 2) + pow(dz, 2)), 3);
                        fx += Gm * (dx / Denom);
                        fy += Gm * (dy / Denom);
                        fz += Gm * (dz / Denom);

                        double[] param = new double[6];
                        param[0] = 0.5 * fx * pow(((k + 1) * pas), 2) + ncorps[n][k].getParam()[3] * ((k + 1) * pas)
                                + ncorps[n][k].getParam()[0];
                        param[1] = 0.5 * fy * pow(((k + 1) * pas), 2) + ncorps[n][k].getParam()[4] * ((k + 1) * pas)
                                + ncorps[n][k].getParam()[1];
                        param[2] = 0.5 * fz * pow(((k + 1) * pas), 2) + ncorps[n][k].getParam()[5] * ((k + 1) * pas)
                                + ncorps[n][k].getParam()[2];
                        param[3] = fx * ((k + 1) * pas) + ncorps[n][k].getParam()[3];
                        param[4] = fy * ((k + 1) * pas) + ncorps[n][k].getParam()[4];
                        param[5] = fz * ((k + 1) * pas) + ncorps[n][k].getParam()[5];

                        Corps corps = new Corps();
                        corps.setParam(param);
                        ncorps[n][k + 1] = corps;

                    }
                }
            }


        }
    }
}

