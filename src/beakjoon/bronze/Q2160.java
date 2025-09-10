package src.beakjoon.bronze;
import java.util.*;
import java.io.*;

class Q2160 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        char[][][] map = new char[N][5][7];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < 5 ; j++ ){
                map[i][j] = br.readLine().toCharArray();
            }
        }
        
        int min = 50;
        int mini = 0;
        int minj = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = i+1 ; j < N ; j++){
                int tmp = 0;
                for(int r = 0 ; r < 5 ; r++){
                    for(int c = 0 ; c < 7 ; c++){
                        if(map[i][r][c] != map[j][r][c]){
                            tmp++;
                        }
                    }
                }
                if(tmp < min){
                    mini = i;
                    minj = j;
                    min = tmp;
                }
            }
        }
        
        System.out.println((mini+1)+" "+(minj+1));
    }
}
