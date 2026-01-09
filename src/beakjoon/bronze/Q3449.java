package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String a = br.readLine();
            String b = br.readLine();

            int distance = 0;

            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    distance++;
                }
            }

            System.out.println("Hamming distance is " + distance + ".");
        }
    }
}
