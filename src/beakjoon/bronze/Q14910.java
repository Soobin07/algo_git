package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q14910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int n = st.countTokens();
        int[] arr = new int[n];
        int[] copy = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            copy[i] = arr[i];
        }

        Arrays.sort(copy);  // 정렬된 배열 만들기

        // 정렬된 배열과 원래 배열 비교
        if (Arrays.equals(arr, copy)) {
            System.out.println("Good");
        } else {
            System.out.println("Bad");
        }
    }
}
