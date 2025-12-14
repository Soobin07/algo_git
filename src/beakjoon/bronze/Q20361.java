package src.beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20361 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int X = Integer.parseInt(st.nextToken()); // 처음 공 위치
        int K = Integer.parseInt(st.nextToken()); // 교환 횟수

        int ball = X;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (ball == A) {
                ball = B;
            } else if (ball == B) {
                ball = A;
            }
        }

        System.out.println(ball);
    }
}
