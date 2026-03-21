package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q4619 {

    static long pow(long a, int n, long limit) {
        long result = 1;
        for (int i = 0; i < n; i++) {
            result *= a;
            if (result > limit) return result; 
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long B = Long.parseLong(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            if (B == 0 && N == 0) break;

            long A = 1;

            while (true) {
                long val = pow(A, N, B);
                if (val >= B) break;
                A++;
            }

            long val1 = pow(A, N, B);
            long val2 = pow(A - 1, N, B);

            if (Math.abs(B - val1) < Math.abs(B - val2)) {
                sb.append(A).append("\n");
            } else {
                sb.append(A - 1).append("\n");
            }
        }

        System.out.print(sb);
    }
}
