package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q18247 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 열 개수
            int M = Integer.parseInt(st.nextToken()); // 행 개수
            
            if (N < 12 || M < 4) {
                System.out.println(-1);
            } else {
                System.out.println(11 * M + 4);
            }
        }
    }
}
