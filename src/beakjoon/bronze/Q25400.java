package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Q25400 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int next = 1; 
        int removed = 0;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == next) {
                next++;
            } else {
                removed++;
            }
        }

        System.out.print(removed);
    }
}
