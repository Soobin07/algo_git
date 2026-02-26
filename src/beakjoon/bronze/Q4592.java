package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            
            if (n == 0) break;
            
            int prev = -1;  
            int curr = -1;
            
            for (int i = 0; i < n; i++) {
                curr = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    sb.append(curr).append(" ");
                    prev = curr;
                } else {
                    if (curr != prev) {
                        sb.append(curr).append(" ");
                        prev = curr;
                    }
                }
            }
            
            sb.append("$\n"); 
        }
        
        System.out.print(sb.toString());
    }
}
