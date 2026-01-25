package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q16466 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 오름차순 정렬

        int expected = 1; // 확인할 숫자 (1부터)
        for (int i = 0; i < N; i++) {
            if (arr[i] == expected) {
                expected++;    // 있으면 다음 숫자로
            }
        }

        System.out.println(expected);
    }
}
