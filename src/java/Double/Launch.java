package java.Double;


public class Launch {
    public static void main(String[] argv) {
        double gm = -1.0;// gm < 0
        double pas = 0.1;
        int Tmax = 50;
        new Initialisation(gm, 10, Tmax, pas).calculate();
    }
}
