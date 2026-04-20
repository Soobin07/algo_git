package src.beakjoon.silver;
import java.io.*;
import java.util.*;

public class Q1495 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] V = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;

        for (int i = 1; i <= N; i++) {
            int diff = V[i - 1];
            for (int v = 0; v <= M; v++) {
                if (!dp[i - 1][v]) continue;

                if (v + diff <= M) {
                    dp[i][v + diff] = true;
                }
                if (v - diff >= 0) {
                    dp[i][v - diff] = true;
                }
            }
        }

        int answer = -1;
        for (int v = 0; v <= M; v++) {
            if (dp[N][v]) {
                answer = Math.max(answer, v);
            }
        }

        System.out.println(answer);
    }
}
