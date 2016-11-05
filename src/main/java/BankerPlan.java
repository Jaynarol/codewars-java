/**
 * https://www.codewars.com/kata/bankers-plan/train/java
 */

public class BankerPlan {

    public static boolean fortune(int f0, double p, int c0, int n, double i) {
        for (int year = 2; year <= n; year++) {
            f0 *= 1+(p/100);
            f0 -= c0;
            c0 *= 1+(i/100);
        }
        return f0 > 0;
    }
}