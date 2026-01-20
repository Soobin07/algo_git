package src.beakjoon.silver;
import java.io.*;
import java.util.*;

public class Q16401 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 조카 수
        int N = Integer.parseInt(st.nextToken()); // 과자 수

        int[] snacks = new int[N];
        st = new StringTokenizer(br.readLine());

        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
            maxLen = Math.max(maxLen, snacks[i]);
        }

        int left = 1;
        int right = maxLen;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            long count = 0;
            for (int snack : snacks) {
                count += snack / mid;
            }

            if (count >= M) { // mid 길이로 M명에게 줄 수 있음
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
