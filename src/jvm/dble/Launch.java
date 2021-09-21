package jvm.dble;

public class Launch {
    private static final int Tmax = 25;

    public static void main(String[] argv) {
        double gm = -1.0;// gm < 0
        double pas = 0.1;

        Initialisation init = new Initialisation(gm, 10, Tmax, pas);
        init.calculate();
        print(init, 4);
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

