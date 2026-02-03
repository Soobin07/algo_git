package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q9455 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int[][] grid = new int[m][n];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            long answer = 0;

            // 열 단위 처리
            for (int col = 0; col < n; col++) {
                int empty = 0;
                for (int row = m - 1; row >= 0; row--) {
                    if (grid[row][col] == 0) {
                        empty++;
                    } else {
                        answer += empty;
                    }
                }
            }

            sb.append(answer).append('\n');
        }

        System.out.print(sb.toString());
    }
}
