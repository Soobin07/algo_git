package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11179 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        String binary = Integer.toBinaryString(n);
        
        String reversed = new StringBuilder(binary).reverse().toString();
        
        int result = Integer.parseInt(reversed, 2);
        
        System.out.println(result);
    }
}
