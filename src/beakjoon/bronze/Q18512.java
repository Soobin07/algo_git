package src.beakjoon.bronze;
import java.util.*;

public class Q18512 {

    static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long X = sc.nextLong();
        long Y = sc.nextLong();
        long P1 = sc.nextLong();
        long P2 = sc.nextLong();

        long g = gcd(X, Y);

        if ((P2 - P1) % g != 0) {
            System.out.println(-1);
            return;
        }

        long limit = lcm(X, Y);

        for (long t = Math.max(P1, P2); 
             t <= Math.max(P1, P2) + limit; 
             t++) {

            if ((t - P1) % X == 0 && (t - P2) % Y == 0) {
                System.out.println(t);
                return;
            }
        }

        System.out.println(-1);
    }
}
