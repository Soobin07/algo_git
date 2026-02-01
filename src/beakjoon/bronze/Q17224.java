package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Q17224 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> scores = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
          
            int sub1 = Integer.parseInt(st.nextToken());
            int sub2 = Integer.parseInt(st.nextToken());

            if (sub2 <= L) {
                scores.add(140);
            } else if (sub1 <= L) {
                scores.add(100);
            }
        }

        Collections.sort(scores, Collections.reverseOrder());

        int result = 0;

        for (int i = 0; i < Math.min(K, scores.size()); i++) {
            result += scores.get(i);
        }

        System.out.println(result);
    }
}
