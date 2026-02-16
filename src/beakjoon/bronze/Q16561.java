package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q16561 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if (N % 3 != 0) {
            System.out.println(0);
            return;
        }
        
        int k = N / 3;
        
        if (k < 3) {
            System.out.println(0);
            return;
        }
        
        long result = (long)(k - 1) * (k - 2) / 2;
        System.out.println(result);
    }
}
