package src.beakjoon.silver;

import java.util.*;
import java.io.*;

class Q2002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        HashMap<String, Integer> in = new HashMap<>();
        for(int i = 0 ; i < N ; i++){
            in.put(br.readLine(), i);
        }
        
        String[] out = new String[N];
        for(int i = 0 ; i < N ; i++){
            out[i] = br.readLine();
        }
        
        int cnt = 0;
        for(int i = 0 ; i < N - 1 ; i++){
           for(int j = i + 1 ; j < N ; j++){
               if(in.get(out[i]) > in.get(out[j])){
                   cnt++;
                   break;
               }
           }
        }
        
        System.out.println(cnt);
    }
}
