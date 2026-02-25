package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q2154 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String N = br.readLine().trim();
        int num = Integer.parseInt(N);
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i <= num; i++) {
            sb.append(i);
        }
        
        int index = sb.indexOf(N);
        
        System.out.println(index + 1);
    }
}
