package src.beakjoon.bronze;

import java.util.*;

class Q28431 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        for(int i = 0 ; i < 5 ; i++){
            arr[sc.nextInt()]++;
        }
        for(int i = 0 ; i < 10 ; i++){
            if(arr[i] % 2 != 0){
                System.out.println(i);
                return;
            }
        }
    }
}
