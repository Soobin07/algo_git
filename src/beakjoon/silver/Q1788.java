package src.beakjoon.silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1788 {
    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());

        if (n == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }

        if (n < 0) {
            long absN = Math.abs(n);
            if (absN % 2 == 0) System.out.println(-1);
            else System.out.println(1);
            n = absN;
        } else {
            System.out.println(1); 
        }

        if (n == 1) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[(int)n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (int)(((long)dp[i-1] + dp[i-2]) % MOD);
        }

        System.out.println(dp[(int)n]);
    }
}
