package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();

            if (line.equals("P=NP")) {
                System.out.println("skipped");
            } else {
                int plusIndex = line.indexOf('+');
                int a = Integer.parseInt(line.substring(0, plusIndex));
                int b = Integer.parseInt(line.substring(plusIndex + 1));
                System.out.println(a + b);
            }
        }
    }
}
