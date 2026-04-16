package src.beakjoon.silver;
import java.util.*;

public class Q1064 {

    static double dist(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        if ((x2 - x1) * (y3 - y1) == (y2 - y1) * (x3 - x1)) {
            System.out.println(-1.0);
            return;
        }

        double ab = dist(x1, y1, x2, y2);
        double bc = dist(x2, y2, x3, y3);
        double ca = dist(x3, y3, x1, y1);

        double p1 = 2 * (ab + bc);
        double p2 = 2 * (bc + ca);
        double p3 = 2 * (ca + ab);

        double max = Math.max(p1, Math.max(p2, p3));
        double min = Math.min(p1, Math.min(p2, p3));

        System.out.printf("%.10f\n", max - min);
    }
}
