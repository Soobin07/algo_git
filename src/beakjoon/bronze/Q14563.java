package src.beakjoon.bronze;
import java.util.*;

public class Q14563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();

            if (n == 1) {
                System.out.println("Deficient");
                continue;
            }

            int sum = 1;

            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    sum += i;
                    if (i != n / i) {
                        sum += n / i;
                    }
                }
            }

            if (sum == n) {
                System.out.println("Perfect");
            } else if (sum < n) {
                System.out.println("Deficient");
            } else {
                System.out.println("Abundant");
            }
        }
    }
}
