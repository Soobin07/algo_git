package src.beakjoon.bronze;

import java.util.*;

class Q6131 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long cnt = 0;
        for(int A = 1 ; A <= 500 ; A++){
            for(int B = 1 ; B <= 500 ; B++){
                if(A*A - B*B == N){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
