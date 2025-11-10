package src.beakjoon.silver;

import java.io.*;
import java.util.*;

public class Q12101 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        int[] dp = new int[12];
        dp[0] = 1;  
        dp[1] = 1;  // 1 = (1)
        dp[2] = 2;  // 2 = (1+1), (2)
        dp[3] = 4;  // 3 = (1+1+1), (1+2), (2+1), (3)

        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        if (k > dp[n]) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        build(n, k, dp, sb);

        System.out.println(sb.toString());
    }

    static void build(int n, long k, int[] dp, StringBuilder sb) {
        if (n == 0) return;

        if (n - 1 >= 0) {
            int count1 = dp[n-1];
            if (k <= count1) {
                sb.append("1");
                if (n - 1 > 0) sb.append("+");
                build(n - 1, k, dp, sb);
                return;
            }
            k -= count1;
        }

        if (n - 2 >= 0) {
            int count2 = dp[n-2];
            if (k <= count2) {
                sb.append("2");
                if (n - 2 > 0) sb.append("+");
                build(n - 2, k, dp, sb);
                return;
            }
            k -= count2;
        }

        if (n - 3 >= 0) {
            int count3 = dp[n-3];
            if (k <= count3) {
                sb.append("3");
                if (n - 3 > 0) sb.append("+");
                build(n - 3, k, dp, sb);
            }
        }
    }
}
