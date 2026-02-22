package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q5724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            
            int result = n * (n + 1) * (2 * n + 1) / 6;
            sb.append(result).append("\n");
        }
        
        System.out.print(sb);
    }
}
