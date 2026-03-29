package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q32068 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            
            int leftDist = S - L;
            int rightDist = R - S;
            
            int result;
            if (rightDist <= leftDist) {
                result = rightDist * 2;
            } else {
                result = leftDist * 2 + 1;
            }
            
            sb.append(result).append('\n');
        }
        
        System.out.print(sb);
    }
}
