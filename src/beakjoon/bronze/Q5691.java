package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q5691 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            
            if (A == 0 && B == 0) break;
            
            sb.append(2 * A - B).append("\n");
        }
        
        System.out.print(sb);
    }
}
