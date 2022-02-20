package tpo.function;

public class Arctg {
    public static double calculate(double x) {
        if (Double.compare(x, 1) > 0 || Double.compare(x, -1) < 0) {
            return Double.NaN; // does not converge
        }
        double r = 0;
        for (int n = 0; n < 10000; n++) {
            r += Math.pow(-1.0, n) * Math.pow(x, 2 * n + 1) / (2 * n + 1);
        }
        return r;
    }
}
