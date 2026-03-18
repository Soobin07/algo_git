package src.beakjoon.silver;
import java.io.*;
import java.util.*;

public class Q10025 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] ice = new int[1000001];

        int maxPos = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            ice[x] = g;
            maxPos = Math.max(maxPos, x);
        }

        int windowSize = 2 * K + 1;

        if (windowSize > 1000001) {
            long sum = 0;
            for (int i = 0; i <= maxPos; i++) {
                sum += ice[i];
            }
            System.out.println(sum);
            return;
        }

        long sum = 0;

        for (int i = 0; i < windowSize && i <= 1000000; i++) {
            sum += ice[i];
        }

        long answer = sum;

        for (int i = windowSize; i <= 1000000; i++) {
            sum += ice[i];
            sum -= ice[i - windowSize];
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}
