package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q17206 {

    static final int MAX = 80000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int[] input = new int[T];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        long[] dp = new long[MAX + 1];

        for (int i = 1; i <= MAX; i++) {
            dp[i] = dp[i - 1];

            if (i % 3 == 0 || i % 7 == 0) {
                dp[i] += i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : input) {
            sb.append(dp[n]).append('\n');
        }

        System.out.print(sb);
    }
}
