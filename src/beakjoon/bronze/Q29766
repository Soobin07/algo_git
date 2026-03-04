package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q29766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int count = 0;
        for (int i = 0; i + 3 < s.length(); i++) {
            if (s.charAt(i) == 'D' && s.charAt(i+1) == 'K' && 
                s.charAt(i+2) == 'S' && s.charAt(i+3) == 'H') {
                count++;
            }
        }

        System.out.println(count);
    }
}
