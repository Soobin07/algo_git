package src.beakjoon.silver;

import java.util.*;
import java.io.*;

class Q11536 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] origin = new String[N];
        String[] order = new String[N];
        String[] rev = new String[N];
        for(int i = 0 ; i < N ; i++){
            String tmp = sc.next();
            origin[i] = tmp;
            order[i] = tmp;
            rev[i] = tmp;
        }
        
        Arrays.sort(order);
        Arrays.sort(rev, Collections.reverseOrder());
        
        boolean flag = true;
        for(int i = 0 ; i < N ; i++){
            if(!origin[i].equals(order[i])){
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.println("INCREASING");
            return;
        }
        
        flag = true;
        for(int i = 0 ; i < N ; i++){
            if(!origin[i].equals(rev[i])){
                flag = false;
                break;
            }
        }
        
        if(flag){
            System.out.println("DECREASING");
            return;
        }else{
            System.out.println("NEITHER");
        }
    }
}
