package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q9550 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int answer = 0;

            for (int i = 0; i < N; i++) {
                int candy = Integer.parseInt(st.nextToken());
                answer += candy / K;
            }

            sb.append(answer).append('\n');
        }

        System.out.print(sb.toString());
    }
}
