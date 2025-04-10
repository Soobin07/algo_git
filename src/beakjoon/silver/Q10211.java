package beakjoon.silver;

import java.util.*;

class Q10211 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0 ; t < T ; t++){
            int N = sc.nextInt();
            int[] arr = new int[N];
            int[] sum = new int[N];
            
            for(int i = 0 ; i < N ; i++){
                arr[i] = sc.nextInt();
            }
            sum[0] = arr[0];
            for(int i = 1 ; i < N ; i++){
                sum[i] = Math.max(arr[i], arr[i] + sum[i-1]);
            }
            
            int max = Integer.MIN_VALUE;
            for(int i = 0 ; i < N ; i++){
                max = Math.max(max, sum[i]);
            }
            
            System.out.println(max);
        }
    }
}
