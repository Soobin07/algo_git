package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11070 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long[] score = new long[n + 1];     // 득점 S
            long[] against = new long[n + 1];   // 실점 A

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());

                score[a] += p;
                against[a] += q;
                score[b] += q;
                against[b] += p;
            }

            double maxW = 0.0;
            double minW = 1.0;

            for (int i = 1; i <= n; i++) {
                double w;
                if (score[i] == 0 && against[i] == 0) {
                    w = 0.0;
                } else {
                    double s2 = (double) score[i] * score[i];
                    double a2 = (double) against[i] * against[i];
                    w = s2 / (s2 + a2);
                }
                maxW = Math.max(maxW, w);
                minW = Math.min(minW, w);
            }

            sb.append((int) (maxW * 1000)).append('\n');
            sb.append((int) (minW * 1000)).append('\n');
        }

        System.out.print(sb.toString());
    }
}
