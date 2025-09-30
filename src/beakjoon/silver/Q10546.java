package src.beakjoon.silver;

import java.io.*;
import java.util.*;

class Q10546 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < N ; i++){
            String tmp = br.readLine();
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        
        for(int i = 0 ; i < N-1 ; i++){
            String tmp = br.readLine();
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        
        String ans = "";
        for(String s : map.keySet()){
            if(map.get(s) % 2 != 0){
                ans = s;
                break;
            }
        }
        System.out.println(ans);
    }
}
