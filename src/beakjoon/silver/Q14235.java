package stc.beakjoon.silver;

import java.io.*;
import java.util.*;

class Q14235 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n = 0 ; n < N ; n++){
            String[] arr = br.readLine().split(" ");
            if(arr.length == 1){
                if(!pq.isEmpty()){
                    System.out.println(pq.poll());
                }else{
                    System.out.println(-1);
                }
            }else{
                int A = Integer.parseInt(arr[0]);
                for(int a = 1 ; a <= A ; a++){
                    pq.add(Integer.parseInt(arr[a]));
                }
            }
        }
    }
}
