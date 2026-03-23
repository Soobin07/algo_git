package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q5566 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] board = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }

        int current = 1;

        for (int i = 1; i <= M; i++) {
            int dice = Integer.parseInt(br.readLine());

            current += dice;

            if (current >= N) {
                System.out.println(i);
                return;
            }

            current += board[current];

            if (current >= N) {
                System.out.println(i);
                return;
            }
        }
    }
}
