package src.beakjoon.bronze;

import java.util.*;
import java.io.*;

class Q25494 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            int cnt = 0;
            
            for(int d = 1 ; d <= a ; d++){
                for(int e = 1 ; e <= b ; e++){
                    for(int f = 1 ; f <= c ; f++){
                        if(d % e == e % f && e % f == f % d){
                            cnt++;
                        }
                    }
                }
            }
            
            System.out.println(cnt);
        }
    }
}
