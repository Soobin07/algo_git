package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q2526 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        int cur = N;
        int idx = 0;

        while (!map.containsKey(cur)) {
            map.put(cur, idx);
            idx++;
            cur = (cur * N) % P;
        }

        System.out.println(idx - map.get(cur));
    }
}
