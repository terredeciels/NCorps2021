package jvm.dble;

public class Launch {
    private static final int Tmax = 25;
    double pasGrille=5;

    public static void main(String[] argv) {
        double gm = -1.0;// gm < 0
        double pas = 0.1;
        int nbcorps=10;
        int DimXYZ=100;


        Initialisation init = new Initialisation(gm, nbcorps, Tmax, pas,DimXYZ);
        init.calculate();
       // print(init, 4);
        print(init);
        convertToBytesRGB(init);
    }

    private static void convertToBytesRGB(Initialisation init) {
        Corps[][] I = init.getNCorpsT0();
        for (int n = 0; n < init.getNbDeCorps(); n++) {
            double[] param = I[n][0].getParam();
            isParamInCellule(param);
        }

    }

    private static boolean isParamInCellule(double[] param) {
        boolean b = false;

        return b;
    }

    private static void print(Initialisation init) {
        Corps[][] I = init.getNCorpsT0();
        for (int n = 0; n < init.getNbDeCorps(); n++) {
            double[] param = I[n][0].getParam();
            System.out.print(param[0]);
            System.out.print(" ; ");
            System.out.print(param[1]);
            System.out.print(" ; ");
            System.out.print(param[2]);
            System.out.println(" ; ");
        }
    }

    static void print(Initialisation init, int n) {
        Corps[][] I = init.getNCorpsT0();
        for (int t = 0; t < Tmax; t++) {
            double[] param = I[n][t].getParam();
            System.out.print(param[0]);
            System.out.print(" ; ");
            System.out.print(param[1]);
            System.out.print(" ; ");
            System.out.print(param[2]);
            System.out.println(" ; ");
        }

    }
}

