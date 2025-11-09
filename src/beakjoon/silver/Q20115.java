package src.beakjoon.silver;

import java.util.*;
import java.io.*;

public class Q20115 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);

        double result = arr[N-1];  // 가장 큰 것 그대로
        for (int i = 0; i < N-1; i++) {
            result += arr[i] / 2.0;
        }

        System.out.println(result);
    }
}
