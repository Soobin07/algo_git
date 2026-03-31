package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q17173 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int k = Integer.parseInt(st.nextToken());

            for (int j = k; j <= N; j += k) {
                visited[j] = true;
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) sum += i;
        }

        System.out.println(sum);
    }
}
