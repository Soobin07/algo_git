package src/beakjoon/silver;

import java.util.*;
import java.io.*;

class Q14620 {
    static int[][] map;
    static boolean[][] visit;
    static int min, N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        // map cost input
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[N][N];
        min = Integer.MAX_VALUE;
        
        //start line
        for(int i = 0 ; i < N * N ; i++){
            solve(i, N, 0, 0);
        }
        
        System.out.println(min);
    }
    
    static void solve(int i, int N, int ans, int depth){
        if(depth == 3){
            min = Math.min(min, ans);
            return;
        }
        if(i >= N * N){
            return;
        }
        
        //do not plant
        solve(i + 1, N, ans, depth);
        
        //plant
        int ir = i / N;
        int ic = i % N;
        
        //flower dead
        if ( ir <= 0 || ic <= 0 || ir >= N-1 || ic >= N-1)
            return;
        if(visit[ir][ic]||visit[ir-1][ic]||visit[ir+1][ic]||visit[ir][ic-1]||visit[ir][ic+1]){
            return;
        }
        
        //planted
        visit[ir][ic] = true;
        visit[ir-1][ic] = true;
        visit[ir+1][ic] = true;
        visit[ir][ic-1] = true;
        visit[ir][ic+1] = true;
        
        //flower cost
        int tmp_i = (map[ir][ic]+map[ir-1][ic]+map[ir+1][ic]+map[ir][ic-1]+map[ir][ic+1]);
            
        //flower plant
        solve(i+1, N, (ans + tmp_i), (depth + 1));
        
        visit[ir][ic] = false;
        visit[ir-1][ic] = false;
        visit[ir+1][ic] = false;
        visit[ir][ic-1] = false;
        visit[ir][ic+1] = false;
    }
}
