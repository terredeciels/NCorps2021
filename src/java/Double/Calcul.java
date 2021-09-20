package java.Double;

import java.math.MathContext;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Calcul {

    int precision = 10;
    MathContext mc = new MathContext(precision);
    private Corps[] ncorps;
    private double pas;
    private int nbcorps;

    public Calcul(Initialisation init, double p) {
        init.getNCorpsT0();
        nbcorps = init.getNbDeCorps();
        pas = p;
        for (int k = 0; k < init.getTmax(); k++) {


            for (int n = 0; n < nbcorps; n++) { //corps n
                double fx = 0.0;
                double fy = 0.0;
                double fz = 0.0;
                for (int m = 0; m < nbcorps; m++) {
                    if (n != m) {
                        double dx = ncorps[n].getParam()[0] - ncorps[n].getParam()[0];
                        double dy = ncorps[n].getParam()[1] - ncorps[n].getParam()[1];
                        double dz = ncorps[n].getParam()[2] - ncorps[n].getParam()[2];

                        double Denom = pow(sqrt(pow(dx, 2) + pow(dy, 2) + pow(dz, 2)), 3);
                        fx += dx / Denom;
                        fy += dy / Denom;
                        fz += dz / Denom;



                    }
                }
            }


        }
    }
}

