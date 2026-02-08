package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Q15781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long maxHelmet = 0;
        long maxVest = 0;

        if (n > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                long val = Long.parseLong(st.nextToken());
                if (val > maxHelmet) {
                    maxHelmet = val;
                }
            }
        } else {
            br.readLine();
        }
        if (m > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                long val = Long.parseLong(st.nextToken());
                if (val > maxVest) {
                    maxVest = val;
                }
            }
        } else {
            br.readLine();
        }
        System.out.println(maxHelmet + maxVest);
    }
}
