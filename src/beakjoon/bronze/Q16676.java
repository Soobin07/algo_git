package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q16676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();

        // N이 0인 경우 → 0 포함, 0보다 작거나 같은 "같은 숫자" 수는 0 하나
        if (input.equals("0")) {
            System.out.println(1);
            return;
        }

        int len = input.length();

        // 같은 자릿수 len 일 때 가능한지
        // 1로 만든 기준값: 111...1 (len 자리)
        StringBuilder ones = new StringBuilder();
        for (int i = 0; i < len; i++) {
            ones.append('1');
        }
        // 비교 값
        if (input.compareTo(ones.toString()) >= 0) {
            System.out.println(len);
        } else {
            System.out.println(len - 1);
        }
    }
}
