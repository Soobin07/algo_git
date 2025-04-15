package beakjoon.bronze;

import java.util.*;

class Q1408 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str_now = sc.next().split(":");
        String[] str_target = sc.next().split(":");
        
        int[] now = new int[3];
        int[] target = new int[3];
        
        for(int i = 0 ; i < 3 ; i++){
            now[i] = Integer.parseInt(str_now[i]);
            target[i] = Integer.parseInt(str_target[i]);
        }
        
        int before = 0;
        int[] answer = new int[3];
        for(int i = 0 ; i < 3 ; i++){
            if(now[2-i] > target[2-i]){
                if(i != 2){
                    target[2-i]+= 60;
                    target[2-i-1]--;
                }else{
                    target[2-i]+= 24;
                }
            }
            answer[2-i] = (target[2-i] - now[2-i]);
        }
        
        System.out.printf("%02d:%02d:%02d",answer[0],answer[1],answer[2]);
    }
}
