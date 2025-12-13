pacakge src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q15780 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int K = Integer.parseInt(st.nextToken()); // 멀티탭 수

        st = new StringTokenizer(br.readLine());
        int total = 0;

        for (int i = 0; i < K; i++) {
            int a = Integer.parseInt(st.nextToken());
            total += a / 2 + a % 2;
        }

        if (total >= N) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
