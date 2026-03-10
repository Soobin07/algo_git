package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q28281 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());

        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long min = Long.MAX_VALUE;

        for (int i = 0; i < N - 1; i++) {
            min = Math.min(min, arr[i] + arr[i + 1]);
        }

        System.out.println(min * X);
    }
}
