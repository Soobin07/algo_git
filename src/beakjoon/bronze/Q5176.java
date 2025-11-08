package src.beakjoon.bronze;

import java.io.*;
import java.util.*;

public class Q5176 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Set<Integer> used = new HashSet<>();
            int cnt = 0;
            for (int i = 0; i < P; i++) {
                int seat = Integer.parseInt(br.readLine());
                if (!used.add(seat)) cnt++; // add 실패 = 중복
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}
