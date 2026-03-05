package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q16396 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        boolean[] line = new boolean[10001];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int j = a; j < b; j++) {
                line[j] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < 10001; i++) {
            if (line[i]) result++;
        }

        System.out.println(result);
    }
}
