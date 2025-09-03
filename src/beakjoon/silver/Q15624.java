package src.beakjoon.silver;

import java.util.*;

class Q15624 {
    static int MAX = 1_000_001;
    static int PER = 1_000_000_007;
    static int corc = 2;
    static long[] arr = new long[MAX];
    static {
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (corc <= N){
            for(int i = corc ; corc <= N ; corc++){
                arr[corc] = (arr[corc - 1] + arr[corc - 2]) % PER;
            }
        }
        System.out.println(arr[N]);
    }
}
