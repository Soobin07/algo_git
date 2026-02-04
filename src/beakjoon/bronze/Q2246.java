package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q2246 {

    static class Condo {
        int d, c;
        Condo(int d, int c) {
            this.d = d;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Condo[] arr = new Condo[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Condo(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            );
        }
        Arrays.sort(arr, (a, b) -> {
            if (a.d != b.d) return a.d - b.d;
            return a.c - b.c;
        });

        int minCost = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i].c < minCost) {
                answer++;
                minCost = arr[i].c;
            }
        }

        System.out.println(answer);
    }
}
