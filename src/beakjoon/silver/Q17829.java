import java.io.*;
package src.beakjoon.silver;
import java.util.*;

public class Q17829 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (N > 1) {
            int[][] next = new int[N / 2][N / 2];

            for (int i = 0; i < N; i += 2) {
                for (int j = 0; j < N; j += 2) {
                    int[] tmp = new int[4];
                    tmp[0] = arr[i][j];
                    tmp[1] = arr[i][j + 1];
                    tmp[2] = arr[i + 1][j];
                    tmp[3] = arr[i + 1][j + 1];
                    Arrays.sort(tmp);          // 오름차순 → tmp[2]가 두 번째 큰 값
                    next[i / 2][j / 2] = tmp[2];
                }
            }

            arr = next;
            N /= 2;
        }

        System.out.println(arr[0][0]);
    }
}
