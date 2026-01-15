package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Q1681 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String L = st.nextToken();  // 비교할 문자

        int count = 0;
        long number = 0;

        while (true) {
            number++;
            // 숫자를 문자열로 변환 후 L이 포함되는지 검사
            if (!Long.toString(number).contains(L)) {
                count++;
                if (count == N) {
                    System.out.println(number);
                    break;
                }
            }
        }
    }
}
