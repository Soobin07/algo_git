import java.io.*;
package src.beakjoon.silver;
import java.util.*;

class Q18511 {
    static int N, K;
    static int[] arrK;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arrK = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arrK[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrK); 
        dfs(0);

        System.out.println(max);
    }
    
    static void dfs(int cur) {
        if (cur > N) return;      
        max = Math.max(max, cur);   

        for (int i = K - 1; i >= 0; i--) { 
            if (cur == 0 && arrK[i] == 0) continue; 
            int next = cur * 10 + arrK[i];
            dfs(next);
        }
    }
}
