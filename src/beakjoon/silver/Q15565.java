package src.beakjoon.silver;
import java.io.*;
import java.util.*;

public class Q15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;
        int countLion = (arr[0] == 1 ? 1 : 0);
        int answer = Integer.MAX_VALUE;

        while (left <= right && right < N) {
            if (countLion >= K) {
                answer = Math.min(answer, right - left + 1);

                if (arr[left] == 1) {
                    countLion--;
                }
                left++;
            } else {
                right++;
                if (right < N && arr[right] == 1) {
                    countLion++;
                }
            }
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
