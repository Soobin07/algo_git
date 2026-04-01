package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q14915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        
        if (N == 0) {
            System.out.println(0);
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (N > 0) {
            int remainder = N % B;
            
            if (remainder < 10) {
                sb.append(remainder);
            } else {
                sb.append((char) ('A' + (remainder - 10)));
            }
            
            N /= B;
        }
        
        System.out.println(sb.reverse());
    }
}
