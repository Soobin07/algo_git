package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        long totalScore = 0; 
        int bonus = 0;  

        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (c == 'O') {
                totalScore += (i + 1) + bonus;
                bonus++; 
            } else {
                bonus = 0;
            }
        }

        System.out.println(totalScore);
    }
}
