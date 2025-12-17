package src.beakjoon.silver;
import java.io.*;
import java.util.*;

public class Q20529 {

    static int dist(String a, String b) {
        int d = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i)) d++;
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");

            HashMap<String, Integer> cnt = new HashMap<>();
            for (String mbti : arr) {
                cnt.put(mbti, cnt.getOrDefault(mbti, 0) + 1);
            }

            boolean zero = false;
            for (int v : cnt.values()) {
                if (v >= 3) {
                    zero = true;
                    break;
                }
            }
            if (zero) {
                sb.append(0).append('\n');
                continue;
            }

            ArrayList<String> list = new ArrayList<>(cnt.keySet());
            int size = list.size();
            int ans = 12; 

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < size; k++) {

                        if (i == j && j == k && cnt.get(list.get(i)) < 3) continue;
                        if (i == j && j != k && cnt.get(list.get(i)) < 2) continue;
                        if (i != j && j == k && cnt.get(list.get(j)) < 2) continue;
                        if (i == k && i != j && cnt.get(list.get(i)) < 2) continue;

                        int d =
                                dist(list.get(i), list.get(j)) +
                                dist(list.get(j), list.get(k)) +
                                dist(list.get(i), list.get(k));

                        ans = Math.min(ans, d);
                    }
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}
