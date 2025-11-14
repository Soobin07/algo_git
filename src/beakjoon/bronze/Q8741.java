package src.beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q8741 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        // 1을 K번
        for (int i = 0; i < K; i++) {
            sb.append('1');
        }
        // 0을 K-1번
        for (int i = 0; i < K - 1; i++) {
            sb.append('0');
        }

        System.out.println(sb);
    }
}
