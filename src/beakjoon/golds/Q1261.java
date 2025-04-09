package beakjoon.golds;

import java.util.*;

class Q1261 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        
        int[][] map = new int[N+1][M+1];
        int[][] count = new int[N+1][M+1];
        for(int i = 1 ; i <= N ; i++){
            String str = sc.next();
            for(int j = 1 ; j <= M ; j++){
                char c = str.charAt(j-1);
                map[i][j] = c-'0';
                count[i][j] = 100_000;
            }
        }
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,1});
        count[1][1] = 0;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int d = 0 ; d < 4 ; d++){
                int tr = now[0] + dr[d];
                int tc = now[1] + dc[d];
                if(tr > N || tr <= 0 || tc > M || tc <= 0){
                    continue;
                }
                if(count[tr][tc] > count[now[0]][now[1]] + map[tr][tc]){
                    count[tr][tc] = count[now[0]][now[1]] + map[tr][tc];
                    q.add(new int[]{tr, tc});
                }
            }
        }
        
        System.out.print(count[N][M]);
    }
}
