package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5704 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String line = br.readLine();
            
            // 종료 조건
            if (line.equals("*")) {
                break;
            }
            
            boolean[] visited = new boolean[26];
            
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                
                if (c >= 'a' && c <= 'z') {
                    visited[c - 'a'] = true;
                }
            }
            
            boolean isPangram = true;
            for (boolean b : visited) {
                if (!b) {
                    isPangram = false;
                    break;
                }
            }
            
            System.out.println(isPangram ? "Y" : "N");
        }
    }
}
