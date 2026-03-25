package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q4806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int count = 0;
        while (true) {
            String line = br.readLine();
            if (line == null) break; 
            count++;
        }
        
        System.out.println(count);
    }
}
