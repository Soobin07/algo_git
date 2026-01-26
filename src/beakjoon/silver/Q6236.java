package src.beakjoon.silver;
import java.io.*;
import java.util.*;

public class Q6236 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int left = 0, right = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            left = Math.max(left, arr[i]); // 최소 K
            right += arr[i];              // 최대 K
        }

        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 1;
            int money = mid;

            for (int i = 0; i < N; i++) {
                if (money < arr[i]) {
                    count++;
                    money = mid;
                }
                money -= arr[i];
            }

            if (count <= M) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
