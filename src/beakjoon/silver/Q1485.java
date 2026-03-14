package src.beakjoon.silver;
import java.io.*;
import java.util.*;

public class Q1485 {

    static int dist(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;
        return dx * dx + dy * dy;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            int[][] p = new int[4][2];

            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                p[i][0] = Integer.parseInt(st.nextToken());
                p[i][1] = Integer.parseInt(st.nextToken());
            }

            int[] d = new int[6];
            int idx = 0;

            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 4; j++) {
                    d[idx++] = dist(p[i][0], p[i][1], p[j][0], p[j][1]);
                }
            }

            Arrays.sort(d);

            if (d[0] > 0 &&
                d[0] == d[1] &&
                d[1] == d[2] &&
                d[2] == d[3] &&
                d[4] == d[5]) {

                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb);
    }
}
