package src.baekjoon.golds;

import java.io.*;
import java.util.*;

class Q2096 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] arr_max = new int[2][3];
        st = new StringTokenizer(br.readLine());
        arr_max[0][0] = Integer.parseInt(st.nextToken());
        arr_max[0][1] = Integer.parseInt(st.nextToken());
        arr_max[0][2] = Integer.parseInt(st.nextToken());
        
        int[][] arr_min = new int[2][3];
        arr_min[0][0] = arr_max[0][0];
        arr_min[0][1] = arr_max[0][1];
        arr_min[0][2] = arr_max[0][2];
        
        if(N == 1){
            System.out.print(Math.max(arr_max[0][0], Math.max(arr_max[0][1], arr_max[0][2]))+" "+Math.min(arr_min[0][0], Math.min(arr_min[0][1], arr_min[0][2])));
        }else{
            for(int n = 1 ; n < N ; n++){
                st = new StringTokenizer(br.readLine());
                for(int i = 0 ; i < 3 ; i++){
                    int now = Integer.parseInt(st.nextToken());
                    arr_max[1][i] = now;
                    arr_min[1][i] = now;
                    if(i == 0){
                        arr_max[1][i] += Math.max(arr_max[0][0], arr_max[0][1]);
                        arr_min[1][i] += Math.min(arr_min[0][0], arr_min[0][1]);
                    }else if(i == 2){
                        arr_max[1][i] += Math.max(arr_max[0][1], arr_max[0][2]);
                        arr_min[1][i] += Math.min(arr_min[0][1], arr_min[0][2]);
                    }else{
                        arr_max[1][i] += Math.max(arr_max[0][0], Math.max(arr_max[0][1], arr_max[0][2]));
                        arr_min[1][i] += Math.min(arr_min[0][0], Math.min(arr_min[0][1], arr_min[0][2]));
                    }
                }
                for(int i = 0 ; i < 3 ; i++){
                    arr_max[0][i] = arr_max[1][i];
                    arr_min[0][i] = arr_min[1][i];
                }
            }
            System.out.print(Math.max(arr_max[1][0], Math.max(arr_max[1][1], arr_max[1][2]))+" "+Math.min(arr_min[1][0], Math.min(arr_min[1][1], arr_min[1][2])));
        }
    }
}
