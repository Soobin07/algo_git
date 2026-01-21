package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5533 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] score = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            int sum = 0;

            for (int j = 0; j < 3; j++) {
                boolean same = false;

                for (int k = 0; k < N; k++) {
                    if (i == k) continue;
                    if (score[i][j] == score[k][j]) {
                        same = true;
                        break;
                    }
                }

                if (!same) {
                    sum += score[i][j];
                }
            }

            System.out.println(sum);
        }
    }
}
