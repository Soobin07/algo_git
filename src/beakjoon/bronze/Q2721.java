package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수 입력
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            // 각 테스트 케이스의 n
            int n = Integer.parseInt(br.readLine());

            // 수학적 공식 적용: n(n+1)(n+2)(n+3)/8
            long result = (long) n * (n + 1) * (n + 2) * (n + 3) / 8;
            System.out.println(result);
        }
    }
}
