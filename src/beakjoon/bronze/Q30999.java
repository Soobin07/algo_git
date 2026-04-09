package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q30999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        int answer = 0;
        
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            
            int count = 0;
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == 'O') {
                    count++;
                }
            }
            
            if (count > M / 2) {
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}
