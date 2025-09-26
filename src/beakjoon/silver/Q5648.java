package src.beakjoon.silver;

import java.util.*;

class Q5648 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        StringBuffer sb = new StringBuffer();
        long[] arr = new long[N];
        for(int n = 0 ; n < N ; n++){
            sb.setLength(0);
            sb.append(sc.next());
            sb.reverse();
            arr[n] = Long.parseLong(sb.toString());
        }
        Arrays.sort(arr);
        sb.setLength(0);
        for(int i = 0 ; i < N ; i++){
            sb.append(arr[i]+"\n");
        }
        System.out.print(sb.toString());
    }
}
