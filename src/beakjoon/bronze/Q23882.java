package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q23882 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for (int i = N - 1; i > 0; i--) {
            int maxIdx = i;

            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }

            if (maxIdx != i) {
                int a = arr[i];
                int b = arr[maxIdx];

                arr[i] = b;
                arr[maxIdx] = a;

                count++;

                if (count == K) {
                    System.out.println(Math.min(a, b) + " " + Math.max(a, b));
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}
