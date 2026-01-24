package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2028 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String n = br.readLine();      // N을 문자열로 받기
            long num = Long.parseLong(n); // 제곱 계산용

            long square = num * num;
            String squareStr = String.valueOf(square);

            if (squareStr.endsWith(n)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
