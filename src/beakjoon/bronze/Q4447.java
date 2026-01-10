package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4447 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            int gCount = 0;
            int bCount = 0;

            String lower = name.toLowerCase();

            for (int j = 0; j < lower.length(); j++) {
                char c = lower.charAt(j);
                if (c == 'g') gCount++;
                else if (c == 'b') bCount++;
            }

            String result;
            if (gCount > bCount) result = "GOOD";
            else if (gCount < bCount) result = "A BADDY";
            else result = "NEUTRAL";

            System.out.println(name + " is " + result);
        }
    }
}
