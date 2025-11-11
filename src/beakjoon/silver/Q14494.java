package src.beakjoon.silver;
import java.util.Scanner;

public class Q14494 {
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[][] dp = new long[n+1][m+1];  // 1-based 사용

        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue;
                long fromUp = (i-1 >= 1) ? dp[i-1][j] : 0;
                long fromLeft = (j-1 >= 1) ? dp[i][j-1] : 0;
                long fromDiag = (i-1 >= 1 && j-1 >= 1) ? dp[i-1][j-1] : 0;
                dp[i][j] = (fromUp + fromLeft + fromDiag) % MOD;
            }
        }

        System.out.println(dp[n][m]);
        sc.close();
    }
}
