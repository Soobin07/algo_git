package src.beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q14606 {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        // bottom-up DP
        for (int i = 2; i <= N; i++) {
            int a = i / 2;
            int b = i - a;
            dp[i] = a * b + dp[a] + dp[b];
        }

        System.out.println(dp[N]);
    }
}
