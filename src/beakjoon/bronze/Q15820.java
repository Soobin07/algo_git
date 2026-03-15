package src.beakjoon.bronze;
import java.util.*;
import java.io.*;

public class Q15820 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S1 = Integer.parseInt(st.nextToken());
        int S2 = Integer.parseInt(st.nextToken());

        for (int i = 0; i < S1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a != b) {
                System.out.println("Wrong Answer");
                return;
            }
        }

        for (int i = 0; i < S2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a != b) {
                System.out.println("Why Wrong!!!");
                return;
            }
        }

        System.out.println("Accepted");
    }
}
