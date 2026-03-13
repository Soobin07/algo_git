package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q17264 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long max = Long.MIN_VALUE;

        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                long num = Long.parseLong(st.nextToken());
                max = Math.max(max, num);
            }
        }

        System.out.println(max);
    }
}
